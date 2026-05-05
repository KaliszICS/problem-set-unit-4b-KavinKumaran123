/**
 * Represents a game board made of tiles and pieces.
 * Uses 2D arrays (objects inside objects).
 * 
 * @author Kavin
 * @version 1.1
 */
public class GameBoard {

    private String[][] tiles;
    private GamePiece[][] pieces;

    // ccustom layout
    public GameBoard(String[][] layout) {
        tiles = layout;
        pieces = new GamePiece[layout.length][layout[0].length];
    }

    // default board 5x5.
    public GameBoard() {

        tiles = new String[5][5];
        pieces = new GamePiece[5][5];

        int count = 1;

        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {

                if (r == 0 && c == 0) {
                    tiles[r][c] = "Start";
                }
                else if (r == tiles.length - 1 && c == tiles[0].length - 1) {
                    tiles[r][c] = "End";
                }
                else {
                    // simple pattern for board
                    if (count % 6 == 0) {
                        tiles[r][c] = "Penalty";
                    }
                    else if (count % 4 == 0) {
                        tiles[r][c] = "Bonus";
                    }
                    else {
                        tiles[r][c] = "Empty";
                    }
                }

                count++;
            }
        }
    }

    public int getRows() {
        return tiles.length;
    }

    public int getCols() {
        return tiles[0].length;
    }

    // helper to check valid position
    private void checkBounds(int row, int col) {
        if (row < 0 || col < 0 || row >= tiles.length || col >= tiles[0].length) {
            throw new IndexOutOfBoundsException("Invalid board position");
        }
    }

    public String getTile(int row, int col) {
        checkBounds(row, col);
        return tiles[row][col];
    }

    public void setTile(int row, int col, String type) {
        checkBounds(row, col);
        tiles[row][col] = type;
    }

    public void placePiece(GamePiece piece, int row, int col) {
        checkBounds(row, col);

        if (piece == null) {
            throw new NullPointerException("Piece cannot be null");
        }

        pieces[row][col] = piece;
    }

    public GamePiece removePiece(int row, int col) {
        checkBounds(row, col);

        if (pieces[row][col] == null) {
            throw new NullPointerException("No piece at this position");
        }

        GamePiece temp = pieces[row][col];
        pieces[row][col] = null;

        return temp;
    }

    public GamePiece getPiece(int row, int col) {
        checkBounds(row, col);
        return pieces[row][col];
    }

    public boolean hasPiece(int row, int col) {
        checkBounds(row, col);
        return pieces[row][col] != null;
    }

    // resets everything except start/end
    public void resetBoard() {

        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {

                if (!tiles[r][c].equals("Start") && !tiles[r][c].equals("End")) {
                    tiles[r][c] = "Empty";
                }

                pieces[r][c] = null;
            }
        }
    }

    // fills board using array (loops if needed)
    public void fillFrom(String[] arr) {

        if (arr == null || arr.length == 0) return;

        int index = 0;

        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {

                tiles[r][c] = arr[index];

                index++;

                if (index >= arr.length) {
                    index = 0;
                }
            }
        }
    }

    public String toString() {

        String out = "";

        for (int r = 0; r < tiles.length; r++) {

            for (int c = 0; c < tiles[r].length; c++) {

                out += tiles[r][c];

                if (pieces[r][c] != null) {
                    out += "(" + pieces[r][c] + ")";
                }

                if (c != tiles[r].length - 1) {
                    out += " | ";
                }
            }

            out += "\n";
        }

        return out;
    }
}