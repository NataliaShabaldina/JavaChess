public class King extends ChessPiece{
    public King(String mycolor)
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
        if (chessBoard.board[toLine][toColumn] != null) return false;
        if (line == toLine && column==toColumn)
            return false;

        if (Math.abs(line-toLine) <=1 && Math.abs (column - toColumn)<=1)
            return true;



        return false;

    }

    @Override
    public String getSymbol() {
        return "K";
    }

    private boolean isUnderAttack(ChessBoard board, int line, int column)
    {
        //проверка угрозы от ферзя, ладьи, слона
        for (int i = 0; i < 7; i++)
        {
            if (!board.board[line][i].getColor().equals(color) && (board.board[line][i].getSymbol().equals("Q") || board.board[line][i].getSymbol().equals("R"))) return true;
            if (!board.board[i][column].getColor().equals(color) && (board.board[i][column].getSymbol().equals("Q") || board.board[i][column].getSymbol().equals("R"))) return true;
            if (line + i < 8 && column + i < 8 && !board.board[line+i][column+i].getColor().equals(color) && (board.board[line+i][column+i].getSymbol().equals("Q") || board.board[line+i][column+i].getSymbol().equals("B"))) return true;
            if (line - i >= 0 && column -i >=0 && !board.board[line-i][column-i].getColor().equals(color) && (board.board[line-i][column-i].getSymbol().equals("Q") || board.board[line-i][column-i].getSymbol().equals("B"))) return true;
            if (line + i < 8 && column - i >=0 && !board.board[line+i][column-i].getColor().equals(color) && (board.board[line+i][column-i].getSymbol().equals("Q") || board.board[line+i][column-i].getSymbol().equals("B"))) return true;
            if (line - i >= 0 && column+i <8 && !board.board[line-i][column+i].getColor().equals(color) && (board.board[line-i][column+i].getSymbol().equals("Q") || board.board[line-i][column+i].getSymbol().equals("B"))) return true;
        }
        //проверка угрозы от коня
        if (line + 2 < 8 && column +1 < 8 && !board.board[line+2][column+1].getColor().equals(color) && board.board[line+2][column+1].getSymbol().equals("H")) return true;
        if (line + 1 < 8 && column +2 < 8 && !board.board[line+1][column+2].getColor().equals(color) && board.board[line+1][column+2].getSymbol().equals("H")) return true;
        if (line + 2 < 8 && column -1 >=0  && !board.board[line+2][column-1].getColor().equals(color) && board.board[line+2][column-1].getSymbol().equals("H")) return true;
        if (line + 1 < 8 && column -2 >=0  && !board.board[line+1][column-2].getColor().equals(color) && board.board[line+1][column-2].getSymbol().equals("H")) return true;
        if (line - 2 >= 0 && column +1 < 8 && !board.board[line-2][column+1].getColor().equals(color) && board.board[line-2][column+1].getSymbol().equals("H")) return true;
        if (line - 1 >= 0 && column +2 < 8 && !board.board[line-1][column+2].getColor().equals(color) && board.board[line-1][column+2].getSymbol().equals("H")) return true;
        if (line - 2 >= 0 && column -1 >= 0  && !board.board[line-2][column-1].getColor().equals(color) && board.board[line-2][column-1].getSymbol().equals("H")) return true;
        if (line - 1 >= 0 && column -2 >= 0  && !board.board[line-1][column-2].getColor().equals(color) && board.board[line-1][column-2].getSymbol().equals("H")) return true;

        //проверка угрозы от пешки
        if (line - 1 >= 0 && column -1 >= 0  && !board.board[line-1][column-1].getColor().equals(color) && board.board[line-1][column-1].getSymbol().equals("P")) return true;
        if (line - 1 >= 0 && column +1 < 8  && !board.board[line-1][column+1].getColor().equals(color) && board.board[line-1][column+1].getSymbol().equals("P")) return true;
        if (line + 1 < 8 && column -1 >=0  && !board.board[line+1][column-1].getColor().equals(color) && board.board[line+1][column-1].getSymbol().equals("P")) return true;
        if (line + 1 < 8 && column +1 < 8  && !board.board[line+1][column+1].getColor().equals(color) && board.board[line+1][column+1].getSymbol().equals("P")) return true;

        return false;
    }
}