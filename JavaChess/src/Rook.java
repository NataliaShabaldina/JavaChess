public class Rook extends ChessPiece{
    public Rook(String mycolor)
    {
        super(mycolor);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7)
            return false;
        if (toColumn < 0 || toColumn > 7)
            return false;
        if (chessBoard.board[toLine][toColumn].color.equals(color)) return false;

       if (line == toLine && column != toColumn)
            return true;
        if (column == toColumn && line != toLine)
            return true;

        return false;

    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
