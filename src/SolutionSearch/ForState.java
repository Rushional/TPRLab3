package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;

import static Model.ProbabilityDistribution.getProbability;

//This is a solution for a particular state at the last month
public class ForState {
    public static StateSolution calculateStateExpected(int monthNumber, int couchesGot, MonthSolution nextMonthSolution) {
        int maxCoachesOrdered = 10 - couchesGot;
        int bestCouchesOrdered = 0; //the most profitable amount of couches to order
        double maxProfit = -100000; //maximum income from this state
        for (int currentCouchesOrdered = 0; currentCouchesOrdered <= maxCoachesOrdered; currentCouchesOrdered++) {
            double expected = - 15 * (currentCouchesOrdered + couchesGot); //maintenance
//            Ordering new couches
            int fullTrips = currentCouchesOrdered / 2; //The amount of trips ordering 2 couches
            int halfTrip = currentCouchesOrdered % 2; //The amount of trips ordering just 1 couch
            expected -= fullTrips*320 + halfTrip*190; //60 per trip + 130 per couch 130*2 + 60 = 320; 130 + 60 = 190
            int coachesSelling = couchesGot + currentCouchesOrdered;
            for (int coachesSoldMax = 0; coachesSoldMax <= 5; coachesSoldMax++) {
                double probability = getProbability(monthNumber, coachesSoldMax);
                int couchesSold = Math.min(coachesSoldMax, coachesSelling);
                double nextMonthExpectedProfit;
                if (monthNumber != 5) {
                    nextMonthExpectedProfit = nextMonthSolution.getStateSolution(coachesSelling - couchesSold).getAverageProfit();
                }
                else nextMonthExpectedProfit = 0;
                expected += probability * (780 * couchesSold + nextMonthExpectedProfit);
            }
            if (expected > maxProfit) {
                maxProfit = expected;
                bestCouchesOrdered = currentCouchesOrdered;
            }
        }
        return new StateSolution(bestCouchesOrdered, maxProfit);
    }
}
