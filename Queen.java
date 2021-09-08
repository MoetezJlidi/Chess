public class Queen extends Piece{
    public Queen(int x, int y, Player owner) {
        super(x, y, owner) ;
    }

    @Override
    public boolean isMoveAuthorized(Board board, Coordinates destination) {
        if (board.sameLineNothingBetween(this.getPosition(),destination)){
            if (board.getPiece(destination) == null)
                return true ;
            if (board.getPiece(destination).getOwner() != owner)
                return true ;
        }
        if (board.sameColumnNothingBetween(this.getPosition(),destination)){
            if (board.getPiece(destination) == null)
                return true ;
            if (board.getPiece(destination).getOwner() != owner)
                return true ;
        }
        if (board.sameDiagonalNothingBetween(this.getPosition(),destination)){
            if (board.getPiece(destination) == null)
                return true ;
            if (board.getPiece(destination).getOwner() != owner)
                return true ;
        }
        return false ;
    }

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public int getValue() {
        return 9;
    }
}

