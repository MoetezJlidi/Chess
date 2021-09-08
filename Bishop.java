public class Bishop extends Piece {

    public Bishop(int x, int y, Player owner){
        super(x, y, owner);
    }

    public boolean isMoveAuthorized(Board board, Coordinates destination){
        if (board.sameDiagonalNothingBetween(this.getPosition(), destination)) {
            if (board.getPiece(destination) == null) {
                return true;
            }

            if (board.getPiece(destination).getOwner() != this.owner) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Type getType() {
        return Type.BISHOP;
    }

    @Override
    public int getValue() {
        return 3;
    }

}
