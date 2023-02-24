package lk.ijse.dep10.io;

import java.util.Properties;

public class EnvDemo2 {
    public static void main(String[] args) {
//        String property = System.getProperty("os.arch");
//        System.out.println(property);

        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            System.out.printf("%s === %s  \n", key,System.getProperty(key.toString()));
        }

        System.out.println(properties.getProperty("os.name"));
        properties.setProperty("os.name","Windows");
        System.out.println(properties.getProperty("os.name"));
        properties.remove("os.name");
        System.out.println(properties.getProperty("os.name"));



    }
}
