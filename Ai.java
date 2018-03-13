package checker.data;

public class Ai {

	public Ai() {
		
	}
	
	public void play_AI(Emplacement[][] emplacements_pion, int depth) {
		
		int max_value= -10000;
		int tmp,max_i,max_j;
		
		for(int i=indexX-2;i<indexX+2;index++) {
			
			for(int j=indexY-2;j<indexY+2;j+=2) { // pour tout les coups possibles
				
				if(isOccupate==false) {	// test si la case est libre ou si elle existe
					//déplacer le pion sur emplacements_pion[i][j]
					tmp=min(emplacements_pion[i][j],depth-1);
					
					if(tmp>max_value) {
						max_value=tmp;
						max_i=i;
						max_j=j;
					}
					
					//libérer la case emplacements_pion[i][j]
				}
			}
		}
		
		//l'emplacements_pion[max_i][max_j] est le solution optimale donc faire le déplacement sur cet emplacement
	}
	
	public int max(Emplacement[] emplacements_pion, int depth) {

		int max_value= -10000;
		
		int i,j,tmp;
		
		for(int i=indexX-2;i<indexX+2;index++) {
			
			for(int j=indexY-2;j<indexY+2;j+=2) { // pour tout les coups possibles
				
				if(isOccupate==false) {	// test si la case est libre ou si elle existe
					//déplacer le pion sur emplacements_pion[i][j]
					tmp=min(emplacements_pion[i][j],depth-1);
					
					if(tmp>max_value) {
						max_value=tmp;
					}
					
					//libérer la case emplacements_pion[i][j]
				}
			}
		}
		return max_value;
	}
	
	public int max(Emplacement[] emplacements_pion, int depth) {

		int min_value= 10000;
		
		int i,j,tmp;
		
		for(int i=indexX-2;i<indexX+2;index++) {
			
			for(int j=indexY-2;j<indexY+2;j+=2) { // pour tout les coups possibles
				
				if(isOccupate==false) {	// test si la case est libre ou si elle existe
					//déplacer le pion sur emplacements_pion[i][j]
					tmp=min(emplacements_pion[i][j],depth-1);
					
					if(tmp>min_value) {
						min_value=tmp;
					}
					
					//libérer la case emplacements_pion[i][j]
				}
			}
		}
		return min_value;
	}
	
}
