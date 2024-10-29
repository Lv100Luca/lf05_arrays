package randomNumbers;

import java.util.Random;

public class RandomNumbers {
    public int[] getRandomNumbers(int number) {
        Random random = new Random();

        int[] randoms = new int[number];

        for (int i = 0; i < number; i++) {
            randoms[i] = random.nextInt(1,10);
        }

        System.out.println(randoms.length);


        return randoms;
    }

    public int evaluateArray(int[] randomNumbers, int digit) {
        int count = 0;

        for (int number : randomNumbers) {
            if (number == digit) {
                count++;
            }
        }

        return count;
    }

    public String getRandomNumbersToString(int[] randomNumbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : randomNumbers) {
            sb.append(number).append(" ");
        }
        return sb.toString();
    }
}