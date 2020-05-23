package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;

import static Model.ProbabilityDistribution.getProbability;

//This is a solution for a particular state at the last month
public class ForState {
    public static StateSolution calculateStateExpected(int monthNumber, int stateCouchesGot, MonthSolution nextMonthSolution) {
        int maxCoachesOrdered = 10 - stateCouchesGot;
        int bestCouchesOrdered = 0; //the most profitable amount of couches to order
        double maxProfit = -100000; //maximum income from this state
        for (int currentDecisionToOrder = 0; currentDecisionToOrder <= maxCoachesOrdered; currentDecisionToOrder++) {
            double decisionProfit = - 15 * (currentDecisionToOrder + stateCouchesGot); //calculate maintenance cost
//            Ordering new couches
            int fullTrips = currentDecisionToOrder / 2; //The amount of trips delivering 2 couches
            int halfTrip = currentDecisionToOrder % 2; //The amount of trips delivering just 1 couch
            decisionProfit -= fullTrips*320 + halfTrip*190; //60 per trip + 130 per couch 130*2 + 60 = 320; 130 + 60 = 190
            int coachesSelling = stateCouchesGot + currentDecisionToOrder;
/*
* It felt weird to try to calculate the Bellman equation in just one line.
* So I didn't.
* Partly it's because combining math expectation and profit calculation
* made it too complex for me to write it in one line
* while maintaining the readability of the rest of the code.
*/
//            create Wi(Si) = PiUi + Wi+1(Si - QiUi)
            for (int coachesSoldMax = 0; coachesSoldMax <= 5; coachesSoldMax++) {
                double probability = getProbability(monthNumber, coachesSoldMax);
                int couchesSold = Math.min(coachesSoldMax, coachesSelling);
                double thisMonthPossibleProfit = 780 * couchesSold; //This step's profit
                double nextMonthPossibleProfit; //Next step's profit
                if (monthNumber != 5) {
                    nextMonthPossibleProfit = nextMonthSolution.getStateSolution(coachesSelling - couchesSold).getAverageProfit();
                }
                else nextMonthPossibleProfit = 0;
//                Calculate the mathematical expectation of this decision's profit
                decisionProfit += probability * (thisMonthPossibleProfit + nextMonthPossibleProfit);
            }
//            get max {PiUi + Wi+1(Si - QiUi)}
            if (decisionProfit > maxProfit) {
                maxProfit = decisionProfit;
                bestCouchesOrdered = currentDecisionToOrder;
            }
        }
        return new StateSolution(bestCouchesOrdered, maxProfit);
    }
}
