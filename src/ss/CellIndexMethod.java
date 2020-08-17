package ss;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CellIndexMethod {
	
	private double M;
	private double L;
	private int pick;
	private double rc;
	private boolean pc;
	private List<Particle> particles;
	List<Particle>[][] heads; 
	
	@SuppressWarnings("unchecked")
	public CellIndexMethod (double M, double L, double rc, boolean pc, int pick, List<Particle> particles) {
		this.M = M;
		this.L = L;
		this.rc = rc;
		this.pc = pc;
		this.particles = particles;
		this.pick = pick;
		
		heads = new LinkedList[(int)M][(int)M]; 
    	
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < M ; j++) {
                heads[i][j] = new LinkedList<Particle>();
            }
        }  
		
	}
	
    public void Compute() {

        for (Particle p : particles){
            int i = (int) ((double)p.getY()/((double)L/(double)M));
            int j = (int) ((double)p.getX()/((double)L/(double)M));
            List<Particle> currentHead = heads[i][j];
            p.setYIndex(i);
            p.setXIndex(j);
            currentHead.add(p);

        }
    	
        for (Particle p : particles){
            int xCell = p.getXIndex();
            int yCell = p.getYIndex();
            
            checkNeighbourCell(p, xCell, yCell);
            checkNeighbourCell(p, xCell + 1, yCell);
            checkNeighbourCell(p, xCell + 1, yCell + 1);
            checkNeighbourCell(p, xCell, yCell + 1);
            checkNeighbourCell(p, xCell + 1, yCell - 1);	
        }

    }
    
    
    private void checkNeighbourCell(Particle particle, int xCell, int yCell) {

        if (pc) {
        	if (xCell >= M){
            	xCell = 0;
            }         
            if (xCell < 0){
            	xCell = (int)M - 1;
            }            
            if (yCell >= M){
            	yCell = 0;
            }
            if (yCell < 0){
            	yCell = (int)M - 1;
            }
        } else {
            if (xCell >= M || xCell < 0 || yCell >= M || yCell < 0) {
                return;
            }
        }        

        for (Particle neighbourCellParticle : this.heads[xCell][yCell]) {

            if (!neighbourCellParticle.equals(particle)) {

                 double distance;

                if (pc) {
                    distance = particle.getPeriodicDistanceTo(neighbourCellParticle, (int)L);
                } else{
                    distance = particle.getDistanceTo(neighbourCellParticle);
                }
                
                if (distance < rc) {
                	if (particle.getId() == this.pick) {
                		neighbourCellParticle.setColor(2);
                		particle.setColor(3);
                	}
			if (neighbourCellParticle.getId() == this.pick ) {
                		particle.setColor(2);
				neighbourCellParticle.setColor(3);
                	}
                    particle.addNeighbour(neighbourCellParticle);
                    neighbourCellParticle.addNeighbour(particle);
                } 

            }
        }
    }


	
	

}
