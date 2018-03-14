import java.io.*;
import java.util.Properties;

public class Config {
    public String GetConfigValue(String key) {
        Properties prop = new Properties();
        String filename = "config.properties";
        File file = new File(
                String.format("%s%ssrc%s/test/resources%s%s",
                        System.getProperty("user.dir"),
                        File.separator,
                        File.separator,
                        File.separator,
                        filename)
        );
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);

    }
}