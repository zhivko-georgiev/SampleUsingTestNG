package bg.mdg.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {
	private final String pathToThePropertiesFile = "src/main/resources/selectors.properties";
	private final Properties configProp = new Properties();

	private PropertiesCache() {
		try {
			System.out.println("Read all properties from file");
			File file = new File(pathToThePropertiesFile);
			FileInputStream fileInput = new FileInputStream(file);
			configProp.load(fileInput);
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class LazyHolder {
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance() {
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return configProp.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return configProp.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return configProp.containsKey(key);
	}
}
