package Model;

public class ProbabilityDistribution {
    private static double[][] probabilities = {
            {0.1, 0.1, 0.2, 0.3, 0.2, 0.1},
            {0.1, 0.1, 0.3, 0.3, 0.1, 0.1},
            {0.1, 0.1, 0.3, 0.3, 0.1, 0.1},
            {0.1, 0.1, 0.2, 0.3, 0.2, 0.1},
            {0.1, 0.1, 0.1, 0.3, 0.3, 0.1},
            {0.1, 0.1, 0.1, 0.3, 0.3, 0.1}
    };

    public static double getProbability(int month, int couchesAmount) {
        return probabilities[month][couchesAmount];
    }
}
