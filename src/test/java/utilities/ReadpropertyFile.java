package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException {
		// object creation 
		FileReader readfile = new FileReader("/Users/piyushwadhwa/eclipse-workspace/TestAutomationFramework/src/test/resources/configfiles/config.properties");
		Properties p  = new Properties ();
		p.load(readfile);
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("Testurl"));

	}

}
