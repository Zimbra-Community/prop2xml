package tk.barrydegraaff;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

public class prop2xml {

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("usage: rootElememtName /path/to/config.properties  /path/to/config_template.xml");
        }
        try {
            Properties props = new Properties();
            FileInputStream inold = new FileInputStream(args[1]);
            props.load(inold);
            inold.close();

            PrintWriter out = new PrintWriter(args[2]);
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<!--");
            out.println("DO NOT MANUALLY CHANGE THIS FILE");
            out.println("Please read the documentation.");
            out.println("-->");

            out.println("<zimletConfig name=\""+args[0]+"\" version=\"1.0\"><global>");


            Enumeration e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                //Skip keys that have `secret` in their name, allows to leave stuff in the .properties file and not expose to Zimlet
                if(key.indexOf("secret")==-1) {
                    out.println("<property name=\"" + key + "\">" + props.getProperty(key) + "</property>");
                }
            }

            out.println("</global></zimletConfig>");
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
    }
}
