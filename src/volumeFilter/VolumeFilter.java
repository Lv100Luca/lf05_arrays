package volumeFilter;

public class VolumeFilter {

    public int[] smoothValues(int[] values) {
        int[] smoothed = new int[values.length];

        smoothed[0] = (values[0] + values[1]) / 2;
        System.out.println(smoothed[0]);

        for (int i = 1; i < values.length - 1; i++) {
            smoothed[i] = (values[i - 1] + values[i] + values[i + 1]) / 3;
            System.out.println(smoothed[i]);
        }

        smoothed[values.length - 1] = (values[values.length - 2] + values[values.length - 1]) / 2;
        System.out.println(smoothed[values.length - 1]);

        return smoothed;
    }
}
