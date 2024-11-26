package candyCrush;

import java.util.ArrayList;
import java.util.List;

public class CandyCrushLogic {
    public static final char[] SYMBOLS = new char[]{'*', '+', '-', '~', '?', '<'};
    public static final boolean ANIMATET_EXPLOSION_ = true;
    public static final int FIELD_SIZE = 5;
    private char[][] field;

    /**
     * Constructor
     * is called to create an object of type CandyCrushLogic
     */
    public CandyCrushLogic() {
        this.field = new char[FIELD_SIZE][FIELD_SIZE];
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                field[y][x] = getRandomSymbol();
            }
        }
        // y / x
    }

    public char[][] getField() {
        return this.field;
    }

    public void setField(char[][] field) {
        this.field = field;
    }

    public void swap(int y1, int x1, int y2, int x2) {
        if (!canSwap(y1, x1, y2, x2))
            throw new IllegalArgumentException("Coordinates are out of bounds");

        char temp = this.field[y1][x1];
        this.field[y1][x1] = this.field[y2][x2];
        this.field[y2][x2] = temp;
        System.out.println("swapped");
    }

    public boolean coordinatesAreInField(int y, int x) {
        return y >= 0 && y < FIELD_SIZE && x >= 0 && x < FIELD_SIZE;
    }

    private boolean coordinatesAreNeighbors(int y1, int x1, int y2, int x2) {
        // dont allow diagonals as well
        int distance = Math.abs(y1 - y2) + Math.abs(x1 - x2);
        return distance == 1;
    }

    public boolean canSwap(int y1, int x1, int y2, int x2) {
        return coordinatesAreInField(y1, x1) && coordinatesAreInField(y2, x2) && coordinatesAreNeighbors(y1, x1, y2, x2);
    }


    public boolean removeMatchingSymbols() {
        ArrayList<List<int[]>> combos = new ArrayList<>();
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (hasComboHorizontal(y, x) != null)
                    combos.add(hasComboHorizontal(y, x));
                if (hasComboVertical(y, x) != null)
                    combos.add(hasComboVertical(y, x));
            }
        }

        System.out.println("Number of Combos: " + combos.size());

        bomba(combos);

        return !combos.isEmpty();
    }

    private void bomba(ArrayList<List<int[]>> combos) {
        // remove all combos
        for (List<int[]> combo : combos) {
            for (int[] pos : combo) {
                field[pos[0]][pos[1]] = ' ';
            }
        }


    }

    private List<int[]> hasComboHorizontal(int vertical, int horizontal) {
        int minComboLength = 3;
        List<int[]> combo = new ArrayList<>();
        combo.add(new int[]{vertical, horizontal});

        while (nextHorizontalMatch(vertical, horizontal)) {
            combo.add(new int[]{vertical, horizontal + 1});
            horizontal++;
        }

        if (combo.size() >= minComboLength) {
            return combo;
        }

        return null;
    }

    private List<int[]> hasComboVertical(int vertical, int horizontal) {
        int minComboLength = 3;
        List<int[]> combo = new ArrayList<>();
        combo.add(new int[]{vertical, horizontal});

        while (nextVerticalMatch(vertical, horizontal)) {
            combo.add(new int[]{vertical + 1, horizontal});
            vertical++;
        }

        if (combo.size() >= minComboLength) {
            return combo;
        }

        return null;
    }

    private boolean nextHorizontalMatch(int vertical, int horizontal) {
        if (horizontal + 1 >= FIELD_SIZE)
            return false;

        if (this.field[vertical][horizontal + 1] == ' ')
            return false;

        return this.field[vertical][horizontal] == this.field[vertical][horizontal + 1];
    }

    private boolean nextVerticalMatch(int vertical, int horizontal) {
        if (vertical + 1 >= FIELD_SIZE)
            return false;

        if (this.field[vertical + 1][horizontal] == ' ')
            return false;

        return this.field[vertical][horizontal] == this.field[vertical + 1][horizontal];
    }

    public void fillField() {
        // replace all with ' ' with symbol above
        for (int y = 0; y < FIELD_SIZE - 1; y++) {
            bubbleBlanksToTop(y);
        }

        // fill in all ' ' with symbol with random symbols
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (field[y][x] == ' ')
                    field[y][x] = getRandomSymbol();
            }
        }
    }

    private void bubbleBlanksToTop(int column) {
        // move all the ' ' symbols to the bottom by swapping them with the symbol above
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int vertical = FIELD_SIZE - 1; vertical > 0; vertical--) {
                if (field[vertical][column] == ' ' && field[vertical - 1][column] != ' ') {
                    swap(vertical, column, vertical - 1, column);
                    swapped = true;
                }
            }
        }
    }

    private char getRandomSymbol() {
        int index = (int) (Math.random() * SYMBOLS.length);
        return SYMBOLS[index];
    }
}
