package fr.eulbobo.template;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class StringTemplateTest {

    @Test
    public void should_get_correct_line_when_setting_parameters() throws IOException {
        Map<String, String> tokens = new HashMap<>();

        tokens.put("parameter", "really");
        tokens.put("otherParameter", "\n");
        tokens.put("lastparam", "pretty much anything");

        String filledTemplate = StringTemplate.fillTemplate("templateTest.template", tokens);

        assertThat(filledTemplate)
                .isNotNull()
                .isEqualTo("this is really my beautiful \n that can do pretty much anything");
    }
}
