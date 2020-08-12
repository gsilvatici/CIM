package main.java.ar.edu.itba.sds;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class MainApp {

	public static void main(String[] args)
	{
		System.out.println("ssss");
		
		List<Particle> particles = null;
		FileParser fp = new FileParser();
		
	    CommandOptions cmd = new CommandOptions(args);
	    cmd.parseOptions();
	    try {
	    	particles = fp.getParticles(cmd.getStaticFile(), cmd.getDinamycFile());
            
	    	if (!cmd.hasOption("df") || !cmd.hasOption("sf")){
                System.out.println("You must specify a static file and a dynamic file!");
                System.exit(1);
            }
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	    
	    CellIndexMethod cellIndexMethod = new CellIndexMethod(cmd.getM(), fp.getL(), cmd.getRc(), cmd.getPc(), particles);
	    
		long start = System.currentTimeMillis();
		
	    cellIndexMethod.Compute();
	    
        long end = System.currentTimeMillis();

        System.out.println("Compute time: " + (end - start) + "ms");	
	}
	
}
