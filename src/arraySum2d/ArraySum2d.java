package arraySum2d;

public class ArraySum2d {
    public int sumAll(int[][] array) throws IllegalArgumentException {
        checkArray(array);

        int sum = 0;

        for (int[] row : array) {
            for (int value : row) {
                sum += value;
            }
        }

        return sum;
    }

    public int[] rowSums(int[][] array) throws IllegalArgumentException {
        checkArray(array);

        int[] sums = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            sums[i] = sumArray(array[i]);
        }

        return sums;
    }

    public int[] colSums(int[][] array) throws IllegalArgumentException {
        checkArray(array);

        int[] sums = new int[array[0].length];

        for (int i = 0; i < array[0].length; i++) {
            sums[i] = sumArray(getRowAt(array, i));
        }

        return sums;
    }

    private int[] getRowAt(int[][] array, int y) {
        int[] row = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            row[i] = getValueFromRowAt(array[i], y);
        }

        return row;
    }

    private int getValueFromRowAt(int[] row, int index) {
        if (index > row.length - 1) return 0;

        return row[index];
    }

    private int sumArray(int[] array) {
        int sum = 0;

        for (int value : array) {
            sum += value;
        }

        return sum;
    }

    private void checkArray(int[][] array) {
        if (array == null) throw new IllegalArgumentException("Array is null");

        if (array.length == 0) throw new IllegalArgumentException("Array is empty");

        for (int[] row : array) {
            System.out.println(row.length);
            if (row.length == 0) throw new IllegalArgumentException("Array-row is empty");
            for (int value : row) {
                if (value < 0) throw new IllegalArgumentException("Array-row contains negative number");
            }
        }
    }
}
