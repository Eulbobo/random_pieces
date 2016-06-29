package fr.eulbobo.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

public class StringTemplate {

    /**
     * Private empty constructor
     */
    private StringTemplate() {
        // private empty constructor
    }

    /**
     * Chargement du fichier template
     *
     * @return contenu du fichier
     */
    private static String loadTemplateFile(final String templateFileName) throws IOException {
        InputStream in = null;
        String result = "";
        Scanner sn = null;
        try {
            in = new ClassPathResource(templateFileName).getInputStream();
            // le délimiteur \\A permet de récupérer tout le flux d'un coup
            sn = new Scanner(in).useDelimiter("\\A");
            result = sn.hasNext()?sn.next():"";
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(sn);
        }
        return result.replaceAll("\r\n", "");
    }

    /**
     * Fill template
     *
     * @param tokens replace template
     * @return remplaced template
     */
    public static String fillTemplate(final String templateFileName, final Map<String, String> tokens) throws IOException {
        String template = loadTemplateFile(templateFileName);

        String patternString = "%(" + StringUtils.join(tokens.keySet(), "|") + ")%";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(template.toString());

        // remplacement des éléments à trouver
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
