package customEventsPackage;

import java.awt.Color;
import java.util.Random;

import checker.core.GameVariableRepository;
import checker.data.Emplacement;
import checker.data.Piece;

public class AreaRock extends AreaEffect {
	private Emplacement e1;
	public AreaRock() {
		
	}
	public Emplacement randomPieces2() {
		Random r = new Random();
		 
        //pick 4 random emplacements in the arrayList
        int index = r.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
       
        
        Emplacement e2=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index);
        while(e2.getIsOccupied()==true) {
        	index = r.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	            e2=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index);
        }
        
       
       /* Piece rock2=new Piece(e2.getPositionX(),e2.getPositionY(),Color.pink,"misterX");
		e2.setOccupyingPiece(rock2);
		e2.getOccupyingPiece().setIsClickeable(false);*/
		return e2;
	}
	public Emplacement randomPieces() {
		
		 Random r = new Random();
		 
        //pick 4 random emplacements in the arrayList
        int index = r.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
       
        
        Emplacement e1=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index);
        while(e1.getIsOccupied()==true) {
        	index = r.nextInt(GameVariableRepository.getInstance().getEmplacementsArrayList().size());
	            e1=GameVariableRepository.getInstance().getEmplacementsArrayList().get(index);
        }
        
       
       /* Piece rock1=new Piece(e1.getPositionX(),e1.getPositionY(),Color.pink,"misterX");
		e1.setOccupyingPiece(rock1);
		e1.getOccupyingPiece().setIsClickeable(false);*/
		return e1;
		/*Piece rock2=new Piece(e2.getPositionX(),e2.getPositionY(),Color.pink,"misterX");
		e2.setOccupyingPiece(rock2);
		e2.getOccupyingPiece().setIsClickeable(false);
		Piece rock3=new Piece(e3.getPositionX(),e3.getPositionY(),Color.pink,"misterX");
		e3.setOccupyingPiece(rock3);
		e3.getOccupyingPiece().setIsClickeable(false);
		Piece rock4=new Piece(e4.getPositionX(),e4.getPositionY(),Color.pink,"misterX");
		e4.setOccupyingPiece(rock4);
		e4.getOccupyingPiece().setIsClickeable(false);*/
	//	e2.setIsOccupied(true);
		//e3.setIsOccupied(true);
		//e4.setIsOccupied(true);
       // effect(e1,e2,e3,e4);
	}
	public void effect() {
		
	}

}
