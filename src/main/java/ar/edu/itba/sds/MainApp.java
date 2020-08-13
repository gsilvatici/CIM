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
	    
    	if (!cmd.hasOption("sf")){
            System.out.println("Static file file not specified!");
            System.exit(1);
        }
    	if (!cmd.hasOption("df") ) {
            System.out.println("Dynamic file file not specified!");
            System.exit(1);
    	}
    	
	    try {
	    	particles = fp.getParticles(cmd.getStaticFile(), cmd.getDinamycFile());
            

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	    
	   
	    
	    CellIndexMethod cellIndexMethod = new CellIndexMethod(cmd.getM(), fp.getL(), cmd.getRc(), cmd.getPc(), particles);
	    
		long start = System.currentTimeMillis();
		
	    cellIndexMethod.Compute();
	    
        long end = System.currentTimeMillis();

        System.out.println("Compute time: " + (end - start) + "ms");	
        
        for (Particle p : particles){
            System.out.print("Particle " + p + " neighbours: ");
            for (Particle neighbour : p.getNeighbours()){
                System.out.print(" " + neighbour);
            }
            System.out.println();
        }
	}
	
}
