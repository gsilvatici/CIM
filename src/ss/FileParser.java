package ss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class FileParser {

	private int particleCount;
	private int lengthSize;
	private LinkedList<Particle> particles;


	public FileParser() {
		this.particles = new LinkedList<Particle>();
	}
	
    public List<Particle> getParticles(String staticFilePath, String dynamicFilePath) throws FileNotFoundException {
        

    	// parse static file
    	FileInputStream fis = new FileInputStream(staticFilePath);  
        Scanner sc = new Scanner(fis);
        particleCount = sc.nextInt();
        lengthSize = sc.nextInt();
        for (int i = 0; i < particleCount; i++) {
            double radius   = sc.nextDouble();
            double property = sc.nextDouble();
            particles.add(new Particle(i, radius, (int)property));
        }    
        
        // parse dynamic file
        fis = new FileInputStream(dynamicFilePath);  
        sc = new Scanner(fis);
        sc.nextInt();
        for (int i = 0; i < particleCount; i++) {
        	double x = sc.nextDouble();
        	double y = sc.nextDouble();
            Particle particle = particles.poll();
            particle.setX(x);
            particle.setY(y);
            particles.add(particle);
        } 	
              
		return particles;
       
	}

	public int getL() {
		return lengthSize;
	}
	
	public int getN() {
		return particleCount;
	}
}
