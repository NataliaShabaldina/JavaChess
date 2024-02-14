abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String mycolor) {
        color = mycolor;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();

}
