package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    static public Properties getConfig() {
        Properties myProp = new Properties();


        try {
            File configExternalFile = new File(System.getProperty("user.dir")+"/config.properties");
            System.out.println("This is user dir file path" + configExternalFile);
            if(configExternalFile.exists()) {
                System.out.println("Using config: "+ configExternalFile.getAbsolutePath());
                myProp.load(new FileInputStream(configExternalFile));
            } else {
                System.out.println("Using default config.properties");
                InputStream fProp = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");

                myProp.load(fProp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myProp;

    }
}
