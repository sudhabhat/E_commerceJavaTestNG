package Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class GetPropertyValues {
	
	
	
	public String getPropValue (String prop_Xpath) throws IOException {
		Properties prop = new Properties();
		String propFileName = "E:\\SudhaDev\\Java\\E_commerceJavaTestNG\\src\\configuration\\config.properties";
		FileInputStream inputStream = new FileInputStream(propFileName);
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
	    return prop.getProperty(prop_Xpath);
	} 
	
	
	
	
}
