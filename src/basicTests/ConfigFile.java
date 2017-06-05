package basicTests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by nikolai on 6/4/17.
 */
public class ConfigFile {
    Properties pro;

    public ConfigFile()
    {
        try {
            File source = new File ("res/configfile");

            FileInputStream input = new FileInputStream(source);

            pro = new Properties();

            pro.load(input);

        } catch (Exception exp) {

            System.out.println("Exception is: ---"+exp.getMessage());
        }
    }
    public String getChromePath()
    {
        String path = pro.getProperty("ChromeDriver");

        return path;
    }
    public String getApplicationURL()
    {
        return pro.getProperty("URL");
    }
}
