public class Horse extends ChessPiece{
public Horse(String mycolor)
{
    super(mycolor);
}

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
    if (line == toLine && column == toColumn)
        return false;
    if (toLine < 0 || toLine > 7) return false;
    if (toColumn < 0 || toColumn > 7) return false;
    if (chessBoard.board[toLine][toColumn].color.equals(color)) return false;
    if (Math.abs(line-toLine) == 1 && Math.abs(column-toColumn) == 2 || Math.abs(line-toLine) == 2 && Math.abs(column-toColumn) == 1)
        return true;
    return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
