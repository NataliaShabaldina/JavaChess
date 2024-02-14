public class Pawn extends ChessPiece{
    public Pawn(String mycolor)
    {
        super(mycolor);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn >7 || line <0 || line >7 || column <0 || column >7)
            return false;
        if (line == toLine && column == toColumn)
            return false;
        if (chessBoard.board[line][column] == null) return false;

        if (column == toColumn)
        {
            if (chessBoard.board[toLine][toColumn] == null)
            {
                if (color.equals("White"))
                {
                    if ((line == 1) && ((toLine - line) == 2) && (chessBoard.board[toLine-1][toColumn] == null)) return true;
                    else
                    if ((line > 1) && ((toLine - line) == 1)) return true;

                }
                if (color.equals("Black"))
                {
                    if ((line == 6) && ((line - toLine) == 2) &&(chessBoard.board[toLine+1][toColumn] == null)) return true;
                    else
                    if ((line < 6) && ((line - toLine) == 1)) return true;

                }
            }
        }
        else if (Math.abs(column - toColumn) == 1)
        {
            if (chessBoard.board[toLine][toColumn] != null)
            {
                if (Math.abs(toLine - line) == 1 && chessBoard.board[toLine][toColumn].color.equals(color)) return true;

            }


        }

        return false;

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}