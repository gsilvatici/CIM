package main.java.ar.edu.itba.sds;

import java.util.LinkedList;
import java.util.List;

public class CellIndexMethod {
	
	private int M;
	private int L;
	private float rc;
	private boolean pc;
	private List<Particle> particles;
	List<Particle>[][] heads; 
	
	public CellIndexMethod (int M, int L, float rc, boolean pc, List<Particle> particles) {
		this.M = M;
		this.L = L;
		this.rc = rc;
		this.pc = pc;
		this.particles = particles;
		heads = new LinkedList[M][M]; 
		
	}
	
    public void Compute() {
    	
        /* builds heads lists */
    	List<Particle>[][] heads = new LinkedList[M][M]; 

        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < M ; j++) {
                heads[i][j] = new LinkedList<Particle>();
            }
        }

        for (Particle p : particles){
            int i = (int) (p.getX()/(L/M));
            int j = (int) (p.getY()/(L/M));
            List<Particle> currentHead = heads[i][j];
            p.setYIndex(i);
            p.setYIndex(j);
            currentHead.add(p);
        }
        
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < M ; j++) {
	            for (Particle p : heads[i][j]){
	                int xCell = p.getXIndex();
	                int yCell = p.getYIndex();
	
	                checkNeighbourCell(p, xCell, yCell);
	                checkNeighbourCell(p, xCell + 1, yCell);
	                checkNeighbourCell(p, xCell + 1, yCell + 1);
	                checkNeighbourCell(p, xCell, yCell + 1);
	                checkNeighbourCell(p, xCell + 1, yCell - 1);
	            }     		                
            }
        }
    }
    
    
    private void checkNeighbourCell(Particle particle, int xCell, int yCell) {

        if (pc) {
        	if (xCell >= M){
            	xCell = 0;
            }         
            if (xCell < 0){
            	xCell = M - 1;
            }            
            if (yCell >= M){
            	yCell = 0;
            }
            if (yCell < 0){
            	yCell = M - 1;
            }
        } else {
            if (xCell >= M || xCell < 0 || yCell >= M || yCell < 0) {
                return;
            }
        }

        for (Particle neighbourCellParticle : heads[xCell][yCell]) {

            if (!neighbourCellParticle.equals(particle)) {

                 double distance;

                if (pc) {
                    distance = particle.getPeriodicDistanceTo(neighbourCellParticle, L);
                } else{
                    distance = particle.getDistanceTo(neighbourCellParticle);
                }

                if (distance < rc) {
                    particle.addNeighbour(neighbourCellParticle);
                    neighbourCellParticle.addNeighbour(particle);
                }

            }
        }
    }


	
	

}
