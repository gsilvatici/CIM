package main.java.ar.edu.itba.sds;

import java.io.FileNotFoundException;

public class MainApp {

	public static void main(String[] args)
	{
		System.out.println("ssss");
		
	    CommandOptions cmd = new CommandOptions(args);
	    cmd.parseOptions();
	    try {
			FileParser.parseStatic(cmd.getStaticFile());
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	
	}
}
