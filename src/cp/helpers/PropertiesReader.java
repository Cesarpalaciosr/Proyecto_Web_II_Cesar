package cp.helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
	
public class PropertiesReader {
		
		Properties prop = new Properties();
		
		public PropertiesReader() {
			try (InputStream is = new FileInputStream(ClassLoader.getSystemResource("config.properties").getPath())) {
				prop.load(is);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public String getValue(String value) {
			return prop.getProperty(value);
		}
}
