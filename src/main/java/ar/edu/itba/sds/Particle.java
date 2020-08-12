package main.java.ar.edu.itba.sds;

import java.util.TreeSet;

public class Particle {
	
    private float x;
    private float y;
    private float radius;
    private float property;

    private int xIndex;
    private int yIndex;
	private int id;
	private TreeSet<Particle> neighbours;

    public Particle(int id, float x, float y, float radius, float property) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.property = property;
    }
    
    Particle(int id, float radius, float property) {
        this.id = id;
        this.radius = radius;
        this.property = property;
        this.neighbours = new TreeSet<>();
    }
    
    public  double getDistanceTo(Particle p) {
        return Math.sqrt(Math.pow(x - p.getX(), 2) +
                Math.pow(y - p.getY(), 2)) - this.radius - p.getRadius();
    }
    
    public double getPeriodicDistanceTo(Particle p, int L) {

        double dx = Math.abs(this.x - p.x);
        if (dx > L / 2)
            dx = L - dx;

        double dy = Math.abs(this.y - p.y);
        if (dy > L / 2)
            dy = L - dy;

        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
    }
    
    public void addNeighbour(Particle neighbour) {
        this.neighbours.add(neighbour);
    }
    
    public float getRadius() {
        return radius;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getProperty() {
        return property;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public int getXIndex() {
        return xIndex;
    }

    public int getYIndex() {
        return yIndex;
    }

    public void setyXYndex(int xIndex) {
        this.xIndex = xIndex;
    }

	public void setYIndex(int yIndex) {
        this.yIndex = yIndex;
    }

	public int getId() {
		return this.id;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (o == null || getClass() != o.getClass()) {
        	return false;
        }

        Particle particle = (Particle) o;

        return id == particle.id;
    }


}
