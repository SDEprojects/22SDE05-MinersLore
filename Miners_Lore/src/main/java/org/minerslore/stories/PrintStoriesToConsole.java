package org.minerslore.stories;

import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;

public class PrintStoriesToConsole {

    public static void parseYaml(){
        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Rand.yaml");
        Yaml yaml = new Yaml();
        Map<String, Object> obj = yaml.load(input);
    }

}
