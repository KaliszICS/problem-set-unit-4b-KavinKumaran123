import java.util.ArrayList;


public class TileStack {

    private ArrayList<String> stack;

    public TileStack(String[] tiles) {

        stack = new ArrayList<>();

        if (tiles != null) {
            for (String t : tiles) {
                stack.add(t);
            }
        }
    }
    public TileStack() {
        stack = new ArrayList<>();
    }
    public String[] getTiles() {
        return stack.toArray(new String[0]);
    }
    public int size() {
        return stack.size();
    }
    public void push(String tile) {

        if (tile == null) {
            throw new NullPointerException("Tile cannot be null");
        }

        stack.add(tile);
    }

    public String pop() {

        if (stack.isEmpty()) return null;

        return stack.remove(stack.size() - 1);
    }

    public String peek() {

        if (stack.isEmpty()) return null;

        return stack.get(stack.size() - 1);
    }

    public String[] removeAll() {

        String[] all = getTiles();
        stack.clear();

        return all;
    }

    public String toString() {

        String out = "";

        for (int i = stack.size() - 1; i >= 0; i--) {

            out += stack.get(i);

            if (i != 0) {
                out += ", ";
            }
        }

        return out;
    }
}