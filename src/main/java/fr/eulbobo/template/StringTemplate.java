package fr.eulbobo.template;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * @param templateFileName nom du fichier template dans le classpath
     * @return contenu du fichier
     */
    private static String loadTemplateFile(final String templateFileName) throws IOException {
        String result = "";
        // le délimiteur \\A permet de récupérer tout le flux d'un coup
        try (InputStream in = new ClassPathResource(templateFileName).getInputStream();
             Scanner sn = new Scanner(in)) {
            sn.useDelimiter("\\A");
            result = sn.hasNext() ? sn.next() : "";
        }
        return result.replaceAll("\r\n", "");
    }

    /**
     * Fill template
     *
     * @param tokens replace template
     * @return remplaced template
     */
    public static String fillTemplate(final String templateFileName, final Map<String, String> tokens)
            throws IOException {
        String template = loadTemplateFile(templateFileName);

        String patternString = "%(" + String.join("|", tokens.keySet()) + ")%";
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
