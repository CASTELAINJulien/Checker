package customEventsPackage;

import java.awt.Color;
import java.util.Random;

import checker.core.GameVariableRepository;
import checker.data.Emplacement;

public class AreaFreeze extends AreaEffect {
	private Emplacement e1;
	private Emplacement e2;
	private Emplacement e3;
	private Emplacement e4;
	
	public AreaFreeze() {
		
        /*this.e1=e1;
        this.e2=e2;
        this.e3=e3;
        this.e4=e4;
        effect(e1,e2,e3,e4);*/
	}
	public void randomPieces() {
		
		 Random r = new Random();
		 Random r2 = new Random();
		 Random r3 = new Random();
		 Random r4 = new Random();
         //pick 4 random emplacements in the arrayList
         int index = r.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
         int index2 = r2.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
         int index3 = r3.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
         int index4 = r4.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
         
         Emplacement e1=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index);
         while(e1.getIsOccupied()==false) {
         	index = r.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	            e1=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index);
         }
         
         Emplacement e2=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index2);
         while(e2.getIsOccupied()==false) {
         	index2 = r2.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	            e2=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index2);
         }
         
         Emplacement e3=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index3);
         while(e3.getIsOccupied()==false) {
         	index3 = r3.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	            e3=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index3);
         }
         
         Emplacement e4=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index4);
         while(e4.getIsOccupied()==false) {
         	index4 = r4.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	            e4=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index4);
         }
        /* this.e1=e1;
         this.e2=e2;
         this.e3=e3;
         this.e4=e4;*/
         effect(e1,e2,e3,e4);
	}
	public void effect(Emplacement e1,Emplacement e2,Emplacement e3, Emplacement e4) {
		
		e1.getOccupyingPiece().setIsClickeable(false);
		e1.getOccupyingPiece().setColor(Color.blue);
		e2.getOccupyingPiece().setIsClickeable(false);
		e2.getOccupyingPiece().setColor(Color.blue);
		e3.getOccupyingPiece().setIsClickeable(false);
		e3.getOccupyingPiece().setColor(Color.blue);
		e4.getOccupyingPiece().setIsClickeable(false);
		e4.getOccupyingPiece().setColor(Color.blue);
		System.out.println("couleur applqiue");
	}
public Emplacement getE1() {
	return this.e1;
}
public Emplacement getE2() {
	return this.e2;
}
public Emplacement getE3() {
	return this.e3;
}
public Emplacement getE4() {
	return this.e4;
}
	public void undoEffect(Emplacement e1,Emplacement e2,Emplacement e3, Emplacement e4) {
		if(e1.getOccupyingPiece().getOwnersName()=="Player 1") {
			e1.getOccupyingPiece().setIsClickeable(true);
			e1.getOccupyingPiece().setColor(Color.red);
		}
		else if(e1.getOccupyingPiece().getOwnersName()=="Player 2") {
			e1.getOccupyingPiece().setIsClickeable(true);
			e1.getOccupyingPiece().setColor(Color.yellow);
		}
		else if(e1.getOccupyingPiece().getOwnersName()=="Player 3") {
			e1.getOccupyingPiece().setIsClickeable(true);
			e1.getOccupyingPiece().setColor(Color.green);
		}
		
		if(e2.getOccupyingPiece().getOwnersName()=="Player 1") {
			e2.getOccupyingPiece().setIsClickeable(true);
			e2.getOccupyingPiece().setColor(Color.red);
		}
		else if(e2.getOccupyingPiece().getOwnersName()=="Player 2") {
			e2.getOccupyingPiece().setIsClickeable(true);
			e2.getOccupyingPiece().setColor(Color.yellow);
		}
		else if(e2.getOccupyingPiece().getOwnersName()=="Player 3") {
			e2.getOccupyingPiece().setIsClickeable(true);
			e2.getOccupyingPiece().setColor(Color.green);
		}
		if(e3.getOccupyingPiece().getOwnersName()=="Player 1") {
			e3.getOccupyingPiece().setIsClickeable(true);
			e3.getOccupyingPiece().setColor(Color.red);
		}
		else if(e3.getOccupyingPiece().getOwnersName()=="Player 2") {
			e3.getOccupyingPiece().setIsClickeable(true);
			e3.getOccupyingPiece().setColor(Color.yellow);
		}
		else if(e3.getOccupyingPiece().getOwnersName()=="Player 3") {
			e3.getOccupyingPiece().setIsClickeable(true);
			e3.getOccupyingPiece().setColor(Color.green);
		}
		if(e4.getOccupyingPiece().getOwnersName()=="Player 1") {
			e4.getOccupyingPiece().setIsClickeable(true);
			e4.getOccupyingPiece().setColor(Color.red);
		}
		else if(e4.getOccupyingPiece().getOwnersName()=="Player 2") {
			e4.getOccupyingPiece().setIsClickeable(true);
			e4.getOccupyingPiece().setColor(Color.yellow);
		}
		else if(e4.getOccupyingPiece().getOwnersName()=="Player 3") {
			e4.getOccupyingPiece().setIsClickeable(true);
			e4.getOccupyingPiece().setColor(Color.green);
		}
	}
}
