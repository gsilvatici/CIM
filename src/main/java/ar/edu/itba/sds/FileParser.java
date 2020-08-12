package main.java.ar.edu.itba.sds;

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
        
//    	parseStaticFile(staticFilePath);
//    	parseDynamicFile(dynamicFilePath);

    	// parse static file
    	FileInputStream fis = new FileInputStream(staticFilePath);  
        Scanner sc = new Scanner(fis);
        particleCount = sc.nextInt();
        lengthSize = sc.nextInt();
        for (int i = 0; i < particleCount; i++) {
            float radius   = sc.nextFloat();
            float property = sc.nextFloat();
            particles.add(new Particle(i, radius, property));
        }    
        sc.close();
        
        // parse dynamic file
        System.out.println(dynamicFilePath);
//        File dynamicFile = new File(dynamicFilePath);
        fis = new FileInputStream(dynamicFilePath);  
        Scanner sc2 = new Scanner(fis);
        sc2.nextInt();
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextLine());
        for (int i = 0; i < particleCount; i++) {
            double x = sc2.nextDouble();
            float y = sc2.nextFloat();
            float vx = sc2.nextFloat(); 
            float vy = sc2.nextFloat(); 
            Particle particle = particles.getFirst();
//            particle.setX(x);
            particle.setY(y);
            particles.add(particle);
        } 	
    	
    	        
		return particles;
       
	}
    
    public void parseStaticFile(String staticFilePath) throws FileNotFoundException {
    	// parse static file
    	FileInputStream fis = new FileInputStream(staticFilePath);  
        Scanner sc = new Scanner(fis);
        particleCount = sc.nextInt();
        lengthSize = sc.nextInt();
        for (int i = 0; i < particleCount; i++) {
            float radius   = sc.nextFloat();
            float property = sc.nextFloat();
            particles.add(new Particle(i, radius, property));
        }    	
    	
    }

    public void parseDynamicFile(String dynamicFilePath) throws FileNotFoundException {
        // parse dynamic file
        System.out.println(dynamicFilePath);
//        File dynamicFile = new File(dynamicFilePath);
        FileInputStream fis = new FileInputStream(dynamicFilePath);  
        Scanner sc = new Scanner(fis);
        sc.nextInt();
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextLine());
//        System.out.println(sc.nextLine());
        for (int i = 0; i < particleCount; i++) {
            double x = sc.nextDouble();
            float y = sc.nextFloat();
            float vx = sc.nextFloat(); 
            float vy = sc.nextFloat(); 
            Particle particle = particles.getFirst();
//            particle.setX(x);
            particle.setY(y);
            particles.add(particle);
        } 	
        sc.close();
    	
    }
	public int getL() {
		return lengthSize;
	}
}
