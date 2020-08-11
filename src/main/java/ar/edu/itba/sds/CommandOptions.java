package main.java.ar.edu.itba.sds;

import java.util.ArrayList;

public class CommandOptions
{
    private int MSize;
    private double interactionRadius;
    private boolean periodicContour = false;
    private boolean bruteForce = false;
    private String staticPFile;
    private String dynamicPFile;
	
    protected ArrayList<String> arguments;
    public CommandOptions(String[] args) {
        parse(args);
    }
    
    public void parse(String[] args) {
        arguments = new ArrayList<String>();
        for ( int i = 0; i < args.length; i++ ) {
            arguments.add(args[i]);
        }
    }
    
    public int size() {
        return arguments.size();
    }
    
    public boolean hasOption(String option) {
        boolean hasValue = false;
        String str;
        for ( int i = 0; i < arguments.size(); i++ ) {
            str = (String)arguments.get(i);
            if ( true == str.equalsIgnoreCase(option) ) {
                hasValue = true;
                break;
            }
        }
        return hasValue;
    }
    
    public String valueOf(String option) {
        String value = null;
        String str;
        for ( int i = 0; i < arguments.size(); i++ ) {
            str = (String)arguments.get(i);
            if ( true == str.equalsIgnoreCase(option) ) {
                value = (String)arguments.get(i+1);
                break;
            }
        }
        return value;
    }
    
    public void parseOptions() {

        try {

            dynamicPFile = valueOf("df");
            staticPFile = valueOf("sf");
            
            System.out.println(valueOf("sf"));

            if (hasOption("M")) {
                MSize = Integer.parseInt(valueOf("M"));
                System.out.println(valueOf("M"));
            }
            
            if (hasOption("rc")) {
                interactionRadius = Double.parseDouble(valueOf("rc"));
            }
            
            if (hasOption("pc")) {
                periodicContour = true;
            }

            if(hasOption("bf")) {
                bruteForce = true;
            }


        } catch (Exception e) {
            System.out.println("Command is not valid.");
        }
    }
    
    public String getStaticFile() {
    	return this.staticPFile;
    }
    
}