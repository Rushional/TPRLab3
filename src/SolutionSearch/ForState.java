package SolutionSearch;

import Solutions.StateSolution;

import static Model.ProbabilityDistribution.getProbability;

//This is a solution for a particular state at the last month
public class ForState {
    public static StateSolution calculateLastStateExpected(int couchesGot) {
        int maxCoachesOrdered = 10 - couchesGot;
        int bestCouchesOrdered = 0; //the most profitable amount of couches to order
        double maxProfit = -2000; //maximum income from this state
        for (int currentCouchesOrdered = 0; currentCouchesOrdered <= maxCoachesOrdered; currentCouchesOrdered++) {
            double expected = - 15 * (currentCouchesOrdered + couchesGot); //maintenance
//            Ordering new couches
            int fullTrips = currentCouchesOrdered / 2; //The amount of trips ordering 2 couches
            int halfTrip = currentCouchesOrdered % 2; //The amount of trips ordering just 1 couch
            expected -= fullTrips*320 + halfTrip*190; //60 per trip + 130 per couch 130*2 + 60 = 320; 130 + 60 = 190
            int coachesSelling = couchesGot + currentCouchesOrdered;
            for (int coachesSoldMax = 0; coachesSoldMax <= 5; coachesSoldMax++) {
                double probability = getProbability(5, coachesSoldMax);
                int couchesSold = Math.min(coachesSoldMax, coachesSelling);
                expected += 780 * couchesSold * probability;
            }
            if (expected > maxProfit) {
                maxProfit = expected;
                bestCouchesOrdered = currentCouchesOrdered;
            }
        }
        return new StateSolution(bestCouchesOrdered, maxProfit);
    }
}
