/**
 * Represents a game piece.
 * Stores  info like label, color, and value.
 */
public class GamePiece {

    private String label;
    private String color;
    private int pointValue;

    public GamePiece(String label, String color, int pointValue) {
        this.label = label;
        this.color = color;
        this.pointValue = pointValue;
    }

    public String getLabel() {
        return label;
    }

    public String getColor() {
        return color;
    }

    public int getPointValue() {
        return pointValue;
    }

    public String toString() {
        return color + " " + label;
    }

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof GamePiece)) return false;

        GamePiece other = (GamePiece) obj;

        return label.equals(other.label)
            && color.equals(other.color)
            && pointValue == other.pointValue;
    }
}