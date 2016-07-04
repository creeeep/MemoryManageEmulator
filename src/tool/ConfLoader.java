package tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfLoader {
	public enum ConfType {
		TLB, Kernal, PageTable, Disk
	};

	private final static String confpath = "configuration/inter.ini";
	private static HashMap<String, Properties> sections;
	private static transient String currentSection;
	private static transient Properties currentProperties;

	public static Properties getPropertiesByConfType(ConfType type) {
		if (sections == null) {
			loadSactionIni();
		}
		return sections.get(type.toString());
	}

	private static void loadSactionIni() {
		try {
			sections=new HashMap<>();
			BufferedReader reader = new BufferedReader(new FileReader(confpath));
			String line;
			while ((line = reader.readLine()) != null)
				parserLine(line);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void parserLine(String line) {
		line = line.trim();
		if(line.length()<1 || line.charAt(0)=='#')
			return;
		
		else if (line.charAt(0)=='[') { // enter a section
			int i=line.indexOf('[');
			int j=line.indexOf(']');
			currentSection=line.substring(i+1, j);
			currentProperties = new Properties();
			sections.put(currentSection, currentProperties);
		} else if (line.matches(".*=.*")) { // a key-value
			if (currentProperties != null) {
				int i = line.indexOf('=');
				String name = line.substring(0, i).trim();
				String value = line.substring(i + 1).trim();
				currentProperties.setProperty(name, value);
			} else
				System.err.println("currentProperties is null");
		}
	}
}
