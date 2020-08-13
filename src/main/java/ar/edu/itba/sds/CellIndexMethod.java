package main.java.ar.edu.itba.sds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CellIndexMethod {
	
	private int M;
	private int L;
	private double rc;
	private boolean pc;
	private List<Particle> particles;
//	List<List<Particle>> heads; 
	List<Particle>[][] heads; 
	
	@SuppressWarnings("unchecked")
	public CellIndexMethod (int M, int L, double rc, boolean pc, List<Particle> particles) {
		this.M = M;
		this.L = L;
		this.rc = rc;
		this.pc = pc;
		this.particles = particles;

		heads = new LinkedList[M][M]; 
    	
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < M ; j++) {
                heads[i][j] = new LinkedList<Particle>();
            }
        }

//		heads = new ArrayList<List<Particle>>();
//
//        for (int i = 0; i < M*M ; i++){
//        	heads.add(new ArrayList<Particle>());
//        }
		
	}
	
    public void Compute() {
    	
        /* builds heads lists */
//    	List<Particle>[][] heads = new LinkedList[M][M]; 
//    	
//        for (int i = 0; i < M ; i++) {
//            for (int j = 0; j < M ; j++) {
//                heads[i][j] = new LinkedList<Particle>();
//            }
//        }

        for (Particle p : particles){
            int i = (int) (p.getY()/(L/M));
            int j = (int) (p.getX()/(L/M));
            List<Particle> currentHead = heads[i][j];
            p.setYIndex(i);
            p.setXIndex(j);
            currentHead.add(p);

            
//            int cellNumber = (int) (cellY * M + cellX);
//            List <Particle> cellParticles = heads.get(cellNumber);
//            p.setCellX(cellX);
//            p.setCellY(cellY);
//            cellParticles.add(p);
        }
        
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < M ; j++) {
	            for (Particle p : heads[i][j]){
	                int xCell = p.getXIndex();
	                int yCell = p.getYIndex();
	                
//	                checkNeighbourCell(p, heads[xCell][yCell], xCell, yCell);
//	                checkNeighbourCell(p, heads[xCell][yCell], xCell + 1, yCell);
//	                checkNeighbourCell(p, heads[xCell][yCell], xCell + 1, yCell + 1);
//	                checkNeighbourCell(p, heads[xCell][yCell], xCell, yCell + 1);
//	                checkNeighbourCell(p, heads[xCell][yCell], xCell + 1, yCell - 1);

	                checkNeighbourCell(p, heads[xCell][yCell], xCell, yCell);
	                checkNeighbourCell(p, heads[xCell][yCell], xCell + 1, yCell);
	                checkNeighbourCell(p, heads[xCell][yCell], xCell + 1, yCell + 1);
	                checkNeighbourCell(p, heads[xCell][yCell], xCell, yCell + 1);
	                checkNeighbourCell(p, heads[xCell][yCell], xCell + 1, yCell - 1);	              
	                
	            }     		                
            }
        }
    }
    
    
    private void checkNeighbourCell(Particle particle, List<Particle> neighbours, int xCell, int yCell) {

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

//        for (Particle neighbourCellParticle : neighbours) {
        for (Particle neighbourCellParticle : this.heads[xCell][yCell]) {

            if (!neighbourCellParticle.equals(particle)) {

                 double distance;

                if (pc) {
                    distance = particle.getPeriodicDistanceTo(neighbourCellParticle, L);
                } else{
                    distance = particle.getDistanceTo(neighbourCellParticle);
                }
//                System.out.println(distance);
                
                if (distance < rc) {
                    particle.addNeighbour(neighbourCellParticle);
                    neighbourCellParticle.addNeighbour(particle);
                } 

            }
        }
    }


	
	

}
