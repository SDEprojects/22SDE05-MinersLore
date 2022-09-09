package org.minerslore.stories;

import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.util.Map;

public class PrintStoriesToConsole {

    static Map<String, Object> obj;

    public static Map<String, Object> parseYaml() throws IOException {
        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Rand.yaml");
        Yaml yaml = new Yaml();
        obj = yaml.load(input);
        return obj;
    }
}
