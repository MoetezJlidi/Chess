import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GameUI {
    public Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;
    private ChessUI ui;
    private Stack<Move> history;
    
    public GameUI(ChessUI ui, String boardConfigFileName, Player white, Player black){
        this.board = new Board(boardConfigFileName, white, black);
        this.white = white;
        this.black = black;
        this.currentPlayer = white;
        this.ui = ui;
	this.history = new Stack<Move>();

        for(Piece p : board.getPieces())
            this.ui.placePiece(p.getType(), p.getColor(), p.getPosition());
    }

    public Board getBoard(){
	return board;
    }
    public boolean undo(){
        if (history.isEmpty()) return false;
        Move preMove = history.pop();
        applyMove(new Move(board, preMove.destination, preMove.origin));
        if (preMove.pieceAtDestination != null) {
            board.addPiece(preMove.pieceAtDestination);
            getOpponent(preMove.pieceAtDestination.owner).removeFromScore(preMove.pieceAtDestination.getValue());
        }
	return true;
    }
    
    public boolean isMovePlayable(Move gameMove){
        if (this.board.isEmptyCell(gameMove.origin)) {
            return false;
        } else if (this.board.getPiece(gameMove.destination) != null && this.board.getPiece(gameMove.origin).getOwner() == this.board.getPiece(gameMove.destination).getOwner()) {
            return false;
        } else if (this.board.getPiece(gameMove.origin).getOwner() != this.currentPlayer) {
            return false;
        } else if (this.isPrey(this.getOpponent(this.currentPlayer).getKing())) {
            return false;
        } else if (!gameMove.pieceAtOrigin.isMoveAuthorized(this.board, gameMove.destination)) {
            return false;
        }
        applyMove(gameMove);
        if (isCheck(currentPlayer)) {
            undo();
            return false;
        }
        undo();

	return true;
    }
    
    public void applyMove(Move move) {
        history.push(move);
        if (move.pieceAtDestination != null) {
            currentPlayer.addToScore(board.getPiece(move.destination).getValue());
            board.emptyCell(move.destination);
        }
        move.pieceAtOrigin.setPosition(move.destination);
        board.addPiece(move.pieceAtOrigin);
        board.emptyCell(move.origin);
        
    }

        public void switchPlayers () {
            currentPlayer = getOpponent(currentPlayer);
        }

        public Player getOpponent (Player player){
            if (player == white) return black;
            return white;
        }

        public boolean isPrey (Piece prey){
            boolean result = false;
            for (Move move : getOpponent(prey.getOwner()).getAllMoves(board)) {
                if (move.destination.equals(prey.getPosition())) {
                    result = true;
                }
            }
            return result;
        }

        public boolean isCheck (Player player){
            return isPrey(player.getKing());
        }

        public boolean isCheckMate (Player player){
            List<Coordinates> list = new ArrayList<>();
            boolean result = true;
            if (isCheck(player)) {
                for (Move move : getOpponent(player).getAllMoves(board)) {
                    if (move.destination.equals(player.getKing().getPosition()))
                        list.add(move.origin);

                }
                for (Move move : player.getAllMoves(board)) {
                    if (move.destination.equals(list.get(0)))
                        result = false;
                }
            }
            return result;
        }

        public void determineWinner () {
            if (white.isCheckMate || black.isCheckMate) {
                System.out.println(getOpponent(currentPlayer).color.toString() + " win!");
                return;
            }
            if (white.getScore() > black.getScore()) {
                System.out.println(white.toString() + " win!");
            }
            if (white.getScore() < black.getScore()) {
                System.out.println(black.toString() + " win!");
            }
            if (white.getScore() == black.getScore()) {
                System.out.println("Draw!");
            }


        }

        public void play () {
            int countWhite = 0;
            int countBlack = 0;

            System.out.println("WHITE :");
            System.out.println("- Move count : " + countWhite);
            System.out.println("- Score : " + white.getScore());
            System.out.println("BLACK :");
            System.out.println("- Move count : " + countBlack);
            System.out.println("- Score : " + black.getScore());
            System.out.println("----------");

            while (countBlack <= 50 || countBlack <= 50) {
                FromTo move = currentPlayer.getFromTo(this);
                while (!isMovePlayable(new Move(board, move))) {
                    move = currentPlayer.getFromTo();
                }
                System.out.print(new Move(board, move));
                applyMove(new Move(board, move));
                ui.placePiece(board.getPiece(move.getTo()).getType(), board.getPiece(move.getTo()).owner.color, move.getTo());
                ui.removePiece(move.getFrom());

                if (currentPlayer.equals(white)) countWhite++;
                else countBlack++;


                switchPlayers();

                if (isCheck(currentPlayer)) System.out.println(currentPlayer + " is check!");

                if (isCheckMate(currentPlayer)) {
                    System.out.println("CHECKMATE!");
                    break;
                }


            }
            determineWinner();
        }


}

