package ModelTester;
import java.util.Scanner;
import Model.AIPlayerModel;
import Model.PlayerModel;
import Model.ShipModel;

public class ModelTester {
	public static void main(String argv[]) {
		Scanner s = new Scanner (System.in);
		
	//=============== player sets all ships ========================
		ShipModel s1 = new ShipModel(1,3,2,true);
		ShipModel s2 = new ShipModel(4,0,3,true);
		ShipModel s3 = new ShipModel(5,6,3,false);
		ShipModel s4 = new ShipModel(7,1,4,true);
		ShipModel s5 = new ShipModel(3,8,5,false);
		PlayerModel p1 = new PlayerModel();
		p1.setShip(s1);
		p1.setShip(s2);
		p1.setShip(s3);
		p1.setShip(s4);
		p1.setShip(s5);
		
			
	//================= AIPlayer sets all ships ==========================
		AIPlayerModel p2 = new AIPlayerModel();
		p2.setShip();
	//================= This nested while loop takes control of hit & continue firing and game over ======================
		boolean playerContinueFire;
		boolean AIContinueFire;
		
		while(true) {
			while(true){
				
				p1.display();
				System.out.println("=====================================================");
				p2.display();
				
				/**
				//testing reset method
				System.out.println("testing");
				int test = s.nextInt();
				if(test == 0) {
					p1.reset();
					p1.display();
					System.out.println("=====================================================");
					p2.display();
				}
				*/
				
				/**
				//testing removeShip method
				System.out.println("testing removeShip, enter x of the ship you want to remove");
				int x = s.nextInt();
				System.out.println("enter x of the ship you want to remove");
				int y = s.nextInt();
				System.out.println("enter the length of the ship");
				int length = s.nextInt();
				System.out.println("enter true/false if ship is vertical");
				boolean vertical = s.nextBoolean();
				p1.removeShip(x, y, length, vertical);
				p1.display();
				System.out.println("=====================================================");
				p2.display();
				//================================================================================
				 */

				
				System.out.println("Enter the x coordinate of your firing position (0 ~ 9): ");
				int xPos = s.nextInt();
				
				System.out.println("Enter the y coordinate of your firing position (0 ~ 9): ");
				int yPos = s.nextInt();
				
				playerContinueFire = p2.attackedByPlayer(xPos, yPos);
				
				if(!playerContinueFire) {
					break;
				}

				if(p2.isGameOver()){
					System.out.println("Congratulation! Player wins!!!!!");
					return;
				}
			}
			
			while(true){
				p1.display();
				System.out.println("=====================================================");
				p2.display();
				
				AIContinueFire = p1.attackedByAI();
				
				if(!AIContinueFire) {
					break;
				}
				
				if(p1.isGameOver()) {
					System.out.println("Unfortunately, AI wins!!!!!");
					return;
				}
				
			}
		}
		//=====================================================================================================
		
	}
}
