package analyzingTemperatureData;

public class TemperatureAnalyzer {

    public int getMaxPeriod(double[] temperatureList, double minimumValue) {
        int count = 0;
        int localCount = 0;
        for (double temperature : temperatureList) {
            if (temperature >= minimumValue) {
                localCount++;
            } else {
                localCount = 0;
            }
            if (localCount > count) {
                count = localCount;
            }
        }

        return count;
    }
}
