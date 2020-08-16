package ss;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) throws IOException
	{
		
		List<Particle> particles = null;
		FileParser fp = new FileParser();
		double start;
		double end;
		
	    CommandOptions cmd = new CommandOptions(args);
	    cmd.parseOptions();
	    
    	if (!cmd.hasOption("-sf")){
            System.out.println("Static file file not specified!");
            System.exit(1);
        }
    	if (!cmd.hasOption("-df") ) {
            System.out.println("Dynamic file file not specified!");
            System.exit(1);
    	}
    	
	    try {
	    	particles = fp.getParticles(cmd.getStaticFile(), cmd.getDinamycFile());
            
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
//	    try (Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("m_compare" + String.valueOf(fp.getN()) + ".txt"), "utf-8"))) {
    	
//	    	writer.write(String.valueOf(fp.getN()) + "\n");
		    
//		    for (int i = 1; i < 20; i++) {  
		    	
			    CellIndexMethod cellIndexMethod = new CellIndexMethod(cmd.getM(), fp.getL(), cmd.getRc(), cmd.getPc(), cmd.getParticle(), particles);
			    
			    start = (double)(System.nanoTime())/(double)(1000000);
				
			    cellIndexMethod.Compute();
			    
			    end = (double)(System.nanoTime())/(double)(1000000);
			    
			    double deltaTime = end - start;
			    
//			    writer.write(String.valueOf(i) + "\t" + String.valueOf(deltaTime) + "\n");
		
		        System.out.println("Cell index method compute time: " + deltaTime + "ms");	
	    	
//		    }
//	    }

        try (Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("output.txt"), "utf-8"))) {
        	
        	writer.write(String.valueOf(fp.getN()) + "\n" + "\n");
        	
            for (Particle p : particles){
            	writer.write(String.valueOf(p.getId()) + "\t" 
            				+ String.valueOf(p.getX()) + "\t"
            				+ String.valueOf(p.getY()) + "\t" 
            				+ String.valueOf(p.getRadius()) + "\t"
            				+ String.valueOf(p.getColor()) + "\n");
                System.out.print("Particle " + p + " neighbours: ");
                for (Particle neighbour : p.getNeighbours()){
                    System.out.print(" " + neighbour);
                   
                }
                
                System.out.println();
                
            }
            
        }
        
        for (Particle p: particles) {
        	p.getNeighbours().clear();
        }        
        
        start = System.currentTimeMillis();
		
		computeBruteForce(fp.getL(), cmd.getRc(), cmd.getPc(), particles);
	    
		end = System.currentTimeMillis();

        System.out.println("Brute force compute time: " + (end - start) + "ms");	
        
	}
	
    private static void computeBruteForce(int L, double rc, boolean pc, List<Particle> particles) {
        for (Particle p1: particles) {
            for (Particle p2: particles) {
                if (!p1.equals(p2) && !p1.getNeighbours().contains(p2)) {
                    
                	double distance;
                    if (pc) {
                        distance = p1.getPeriodicDistanceTo(p2, L);
                    }else {
                        distance = p1.getDistanceTo(p2);
                    }
                    if (distance < rc) {
                        p1.addNeighbour(p2);
                        p2.addNeighbour(p1);
                    }
                }
            }
        }
    }
}
