package test;

import java.io.PrintStream;
import java.util.Properties;

import tool.ConfLoader;
import tool.ConfLoader.ConfType;

public class CLTest {

	public static void main(String[] args) {
		Properties properties=ConfLoader.getPropertiesByConfType(ConfType.Disk);
		properties.list(new PrintStream(System.out));
	}

}
