//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ChessBot extends Player {
    ChessUI ui ;
    
    public ChessBot(ChessUI ui,ChessColor color) {
        super(color);
        this.ui = ui;
    }

    public FromTo getFromTo() {
       return null ;
    }

    @Override
    public FromTo getFromTo(GameUI gameUI) {
        List<Integer> scores = new ArrayList();
        List<Move> moves = this.getAllMoves(gameUI.board);
        List<Move> nullDestination = new ArrayList();
        List<Move> notNullDestination = new ArrayList();
        Random random = new Random();
        Iterator var6 = moves.iterator();

        Move move;
        while(var6.hasNext()) {
            move = (Move)var6.next();
            if (move.pieceAtDestination == null) {
                nullDestination.add(move);
            } else {
                notNullDestination.add(move);
            }
        }

        var6 = notNullDestination.iterator();

        while(var6.hasNext()) {
            move = (Move)var6.next();
            scores.add(gameUI.board.getPiece(move.destination).getValue());
        }

        int maxScore;
        if (scores.isEmpty()) {
            maxScore = random.nextInt(nullDestination.size());
            return new FromTo(((Move)nullDestination.get(maxScore)).origin.getY(), ((Move)nullDestination.get(maxScore)).origin.getX(), ((Move)nullDestination.get(maxScore)).destination.getY(), ((Move)nullDestination.get(maxScore)).destination.getX());
        } else {
            maxScore = (Integer)scores.get(0);
            int indice = 0;

            int j;
            for(j = 1; j < scores.size(); ++j) {
                if ((Integer)scores.get(j) > maxScore) {
                    maxScore = (Integer)scores.get(j);
                }
            }

            for(j = 0; j < scores.size(); ++j) {
                if ((Integer)scores.get(j) == maxScore) {
                    indice = j;
                }
            }

            Coordinates from = ((Move)notNullDestination.get(indice)).origin;
            Coordinates to = ((Move)notNullDestination.get(indice)).destination;
            return new FromTo(from.getY(), from.getX(), to.getY(), to.getX());
        }
    }
}
