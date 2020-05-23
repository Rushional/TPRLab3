package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;

import static Model.ProbabilityDistribution.getProbability;

// This is a solution for a particular state at the last month.
// A state here is the amount of couches at the start of the month.
// So depending on the amount of couches ready a particular decision is made.
class ForState {
    static StateSolution calculateStateExpected(int monthNumber, int stateCouchesGot, MonthSolution nextMonthSolution) {
        final int storageCost = 30; // How much it costs to store a couch for a month
        int maxCoachesOrdered = 10 - stateCouchesGot;
        int bestCouchesOrdered = 0; // the most profitable amount of couches to order
        double maxProfit = -100000; // maximum income from this state
        for (int currentDecisionToOrder = 0; currentDecisionToOrder <= maxCoachesOrdered; currentDecisionToOrder++) {
            double decisionProfit = - storageCost * (currentDecisionToOrder + stateCouchesGot); // calculate maintenance cost
//            Ordering new couches
            int fullTrips = currentDecisionToOrder / 2; //The amount of trips delivering 2 couches
            int halfTrip = currentDecisionToOrder % 2; //The amount of trips delivering just 1 couch
            decisionProfit -= fullTrips*320 + halfTrip*190; //60 per trip + 130 per couch 130*2 + 60 = 320; 130 + 60 = 190
            int coachesSelling = stateCouchesGot + currentDecisionToOrder;
            /*
            * I remember that the task was to calculate the Bellman equation in one line.
            * But I felt that for this particular problem this is harder to achieve,
            * partly because I needed to combine calculating math expectation and profit.
            * I think that writing it in one line would mean that other lines become
            * significantly less readable as a result, so I opted for a different solution.
            * However, I still tried to make the Bellman equation as readable as I could.
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
