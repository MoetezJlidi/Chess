import java.io.*;
import java.util.Scanner;

public class TestChess{

	public static void main(String[] args) {
	    
	    boolean result;

	    /* Test de déplacements autorisés selon les regles de pièces */
	    System.out.println("authorized moves");
	    System.out.print("test 1 white pawn : ");
	    result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,1), new Coordinates(0,2));
	    if(result == true) System.out.println("pass"); else System.out.println("fail");
	    
	    System.out.print("test 2 white pawn : ");
	    result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,1), new Coordinates(0,4));
	    if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 white pawn : ");
		result = testAuthorizedMove("boardConfigurationFiles/whitePawn.txt", new Coordinates(0,3), new Coordinates(0,4));
		if(result == true) System.out.println("pass"); else System.out.println("fail");


		System.out.print("test 1 king : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(3,0), new Coordinates(3,1));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 king : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(3,0), new Coordinates(3,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 king : ");
		result = testAuthorizedMove("boardConfigurationFiles/king.txt", new Coordinates(3,0), new Coordinates(2,1));
		if(result == true) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 4 king : ");
		result = testAuthorizedMove("boardConfigurationFiles/king.txt", new Coordinates(3,0), new Coordinates(3,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");


		System.out.print("test 1 black pawn : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,6), new Coordinates(0,5));
		if(result == true) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 black pawn : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,6), new Coordinates(0,3));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 black pawn : ");
		result = testAuthorizedMove("boardConfigurationFiles/blackPawn.txt", new Coordinates(0,4), new Coordinates(0,3));
		if(result == true) System.out.println("pass"); else System.out.println("fail");


		System.out.print("test 1 queen : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(4,0), new Coordinates(4,4));
		if(result == true) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 queen : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(4,0), new Coordinates(5,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 queen : ");
		result = testAuthorizedMove("boardConfigurationFiles/queen.txt", new Coordinates(4,0), new Coordinates(4,6));
		if(result == true) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 1 bishop : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(2,0), new Coordinates(0,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 bishop : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(2,0), new Coordinates(3,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 bishop : ");
		result = testAuthorizedMove("boardConfigurationFiles/bishop.txt", new Coordinates(3,0), new Coordinates(2,1));
		if(result == true) System.out.println("pass"); else System.out.println("fail");


		System.out.print("test 1 knight : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(1,0), new Coordinates(2,2));
		if(result == true) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 knight : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(1,0), new Coordinates(3,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 knight : ");
		result = testAuthorizedMove("boardConfigurationFiles/knight.txt", new Coordinates(4,0), new Coordinates(3,2));
		if(result == true) System.out.println("pass"); else System.out.println("fail");


		System.out.print("test 1 rook : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,0), new Coordinates(0,2));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 2 rook : ");
		result = testAuthorizedMove("boardConfigurationFiles/FullBoard.txt", new Coordinates(0,0), new Coordinates(2,0));
		if(result == false) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 rook : ");
		result = testAuthorizedMove("boardConfigurationFiles/rook.txt", new Coordinates(3,0), new Coordinates(3,6));
		if(result == true) System.out.println("pass"); else System.out.println("fail");



		/*  Test de déplacements jouables sur l'échiquier actuel, selon les regles du jeu */
	    System.out.println("playable moves");
	    System.out.print("test 1 : ");
	    result = testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(0,1),new Coordinates(0,2));
	    if(result == true) System.out.println("pass"); else System.out.println("fail");

	    System.out.print("test 2 : ");
	    result = testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(0,1),new Coordinates(0,3));
	    if(result == true) System.out.println("pass"); else System.out.println("fail");

		System.out.print("test 3 : ");
		result = testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(0,3),new Coordinates(0,4));
		if(result == false) System.out.println("pass"); else System.out.println("fail"); //Pour tester le cas où les 2 coordonnées sont vides

		System.out.print("test 4 : ");
		result = testPlayableMove("boardConfigurationFiles/FullBoard.txt",new Coordinates(3,0),new Coordinates(3,1));
		if(result == false) System.out.println("pass"); else System.out.println("fail");//



		/*  Tests de la mise en échec */
	    
	    /*  Tests de la Echec et mat "isCheckMate()" */
	    
	    /*  Tests pours le calcul des points en fin de partie */
    }

    
    public static boolean testAuthorizedMove(String filename, Coordinates origin, Coordinates destination) {    			
	ChessUI ui = new ChessUI();
	Board testBoard = new Board(filename, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
	Piece testPiece = testBoard.getPiece(origin);
	if(testPiece == null) {
	    System.out.println("No Piece at :"+origin); 
	    return false;
	}
	return testPiece.isMoveAuthorized(testBoard, destination);
    }

	
    public static boolean testPlayableMove(String fileName, Coordinates origin, Coordinates destination) {    			
	ChessUI ui = new ChessUI();
	GameUI g = new GameUI(ui, fileName, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
	
	Piece testPiece = g.getBoard().getPiece(origin);
	if(testPiece == null) {
	    System.out.println("No Piece at :"+origin); 
	    return false;
	}
	return g.isMovePlayable(new Move(g.getBoard(), origin, destination));
    }

    public static boolean testIsCheck(String fileName, Player p) {    			
	ChessUI ui = new ChessUI();
	GameUI g = new GameUI(ui, fileName, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
	return g.isCheck(p);
    }

    public static boolean testIsCheckMate(String fileName, Player p) {    			
	ChessUI ui = new ChessUI();
	GameUI g = new GameUI(ui, fileName, new Human(ui, ChessColor.WHITE), new Human(ui, ChessColor.BLACK));
	return g.isCheck(p) && g.isCheckMate(p);
    }

	
}

