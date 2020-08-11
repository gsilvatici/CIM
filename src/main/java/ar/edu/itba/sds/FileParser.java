package main.java.ar.edu.itba.sds;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileParser {

	private static int particleCount;
	private static int lengthSize;
//	private static List<Particle> particles = new LinkedList<Particle>();


    public static void parseStatic(String staticFilePath) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(staticFilePath);  
        Scanner sc = new Scanner(fis);
        particleCount = sc.nextInt();
        lengthSize = sc.nextInt();
        for (int i = 0; i < particleCount; i++){

        }
        
		        
	        
//	        try  
//	        {  
//		        File file = new File(staticFile);    
//		        FileReader fr = new FileReader(file);  
//		        BufferedReader br = new BufferedReader(fr); 
//		        StringBuffer sb = new StringBuffer();   
//		        String line;  
//		        while((line = br.readLine()) != null) {  
//		        	int aux = Integer.parseInt(line);  
//		        	System.out.println(aux);   
//			        sb.append(line);     
//			        sb.append("\n");     
//		        }  
//		        fr.close();    //closes the stream and release the resources  
//		        System.out.println("Contents of File: ");  
//		        System.out.println(sb.toString());   //returns a string that textually represents the object  
//		    } catch(IOException e) {  
//		        	System.out.println("There was an error reading the file");
//		    }        
	    }
}
