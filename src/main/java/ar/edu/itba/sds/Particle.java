package main.java.ar.edu.itba.sds;

public class Particle {
	
    private double x;
    private double y;
    private double radius;
    private double property;

    private double xIndex;
    private double yIndex;

    public Particle(int id, double x, double y, double radius, double property){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.property = property;
    }

    public double getDistanceTo(Particle p){
        return Math.sqrt(Math.pow(x - p.getX(), 2) +
                Math.pow(y - p.getY(), 2)) - this.radius - p.getRadius();
    }
    
    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getProperty() {
        return property;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getCellX() {
        return xIndex;
    }

    public double getYindex() {
        return yIndex;
    }

    public void setyXindex(double xIndex) {
        this.xIndex = xIndex;
    }

    public void setYindex(double yIndex) {
        this.yIndex = yIndex;
    }



}
