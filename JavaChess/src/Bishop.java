public class Bishop extends ChessPiece{
    public Bishop(String mycolor)
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

        if (line == toLine && column==toColumn)
            return false;
        int difLine=0, difColumn=0;
        if (line > toLine)
            difLine = line - toLine;
        else
            difLine = toLine - line;
        if (column > toColumn)
            difColumn = column - toColumn;
        else
            difLine = toColumn - column;


        if (difLine == difColumn)
            return true;



        return false;

    }

    @Override
    public String getSymbol() {
        return "B";
    }
}