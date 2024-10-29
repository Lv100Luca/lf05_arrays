package arrayCalculator;


public class ArrayCalculator {
    public int[] duplicateArrayValues(int[] array) {
        if (array == null)
            return null;

        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i] * 2;
        }

        return newArray;
    }

    public int[] sumArrays(int[] array1, int[] array2) throws IllegalArgumentException {
        if (array1 == null || array2 == null) {
            return null;
        }

        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        int[] arraySum = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            arraySum[i] = array1[i] + array2[i];
        }

        return arraySum;
    }

    public int[] swapArrays(int[] array) {
        if (array == null)
            return null;
        int len = array.length;
        int[] swappedArray = new int[len];

        for (int i = 0; i < len; i++) {
            int revIndex = len - i - 1;
            swappedArray[revIndex] = array[i];
        }

        return swappedArray;
    }

    public int sumEven(int[] array) {
        if (array == null)
            return 0;

        int sum = 0;

        for (int number : array) {
            if (isEven(number))
                sum += number;
        }

        return sum;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int[] getLargestTwo(int[] array) throws IllegalArgumentException {
        if (array == null) return null;

        if (array.length <= 1)
            throw new IllegalArgumentException();

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : array) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest) {
                secondLargest = number;
            }
        }

        return new int[]{largest, secondLargest};
    }
}
