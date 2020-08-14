package ss;

import java.util.ArrayList;

public class CommandOptions
{
    private int MSize;
    private int paticleId;
    private double rc;
    private boolean pc = false;
    private boolean bf = false;
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

            dynamicPFile = valueOf("-df");
            staticPFile = valueOf("-sf");
       
            if (hasOption("-M")) {
                MSize = Integer.parseInt(valueOf("-M"));
            } else {
            	MSize = 5;
            }
            
            if (hasOption("-rc")) {
            	rc = Float.parseFloat(valueOf("-rc"));
            } else {
            	rc = 1;
            }
            
            if (hasOption("-pc")) {
            	pc = true;
            } else {
            	pc = false;
            }
            
            if(hasOption("-pick")) {
            	paticleId = Integer.parseInt(valueOf("-pick")); 
            } else {
            	paticleId = 90;
            }

            if(hasOption("-bf")) {
                bf = true;
            }


        } catch (Exception e) {
            System.out.println("Command is not valid.");
        }
    }
    
    public String getStaticFile() {
    	return this.staticPFile;
    }
    
    public String getDinamycFile() {
    	return this.dynamicPFile;
    }

	public int getM() {
		return this.MSize;
	}

	public double getRc() {
		return this.rc;
	}

	public boolean getPc() {
		return this.pc;
	}
    
	public int getParticle() {
		return this.paticleId;
	}
}