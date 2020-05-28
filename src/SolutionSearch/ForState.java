package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;

import static Model.ProbabilityDistribution.getProbability;

// This class finds a solution for a particular state at the last month.
// A state here is the amount of couches at the start of the month.
// So depending on the amount of couches ready a particular decision is made.
class ForState {
    private static int couchIncome = 780; // c

    static StateSolution calculateStateExpected(int monthNumber, int stateCouchesGot, MonthSolution nextMonthSolution) {
        final int storageCost = 15; // How much it costs to store a couch for a month
        int maxCoachesOrdered = 10 - stateCouchesGot; //10 - Si
        int bestCouchesOrdered = 0; // the most profitable amount of couches to order
        double maxProfit = -100000; // maximum income from this state
        for (int currentDecisionToOrder = 0; currentDecisionToOrder <= maxCoachesOrdered; currentDecisionToOrder++) {
            int holdingCost = storageCost * (currentDecisionToOrder + stateCouchesGot);
//            double decisionProfit = - storageCost * (currentDecisionToOrder + stateCouchesGot); // calculate maintenance cost
//            Ordering new couches
            int fullTrips = currentDecisionToOrder / 2; //The amount of trips delivering 2 couches
            int halfTrip = currentDecisionToOrder % 2; //The amount of trips delivering just 1 couch
            int orderCost = fullTrips*320 + halfTrip*190; //60 per trip + 130 per couch 130*2 + 60 = 320; 130 + 60 = 190
            int monthCosts = holdingCost + orderCost;
            double decisionProfit = 0;
            int couchesToSell = stateCouchesGot + currentDecisionToOrder; //Si + Ui
            for (int coachesSoldMax = 0; coachesSoldMax <= 5; coachesSoldMax++) {
                double probability = getProbability(monthNumber, coachesSoldMax);
                int couchesSold = Math.min(coachesSoldMax, couchesToSell); //Qi(Ui, Yik) = min{Si+Ui, Yik}
                double thisMonthPossibleProfit = couchIncome * couchesSold; //This step's profit
//                double nextMonthPossibleProfit; //Next step's profit
//                if (monthNumber != 5) {
//                    nextMonthPossibleProfit = nextMonthSolution.getStateSolution(couchesToSell - couchesSold).getAverageProfit();
//                }
//                else nextMonthPossibleProfit = 0;
//                Calculate the mathematical expectation of this decision's profit
//                decisionProfit += probability * (thisMonthPossibleProfit + nextMonthPossibleProfit);
                if (monthNumber != 5) {
//                    SUM(P(Yik)*(wтек(Ui) - Cтек(Ui) + Wi+1(Si + Ui - Qi(Ui, k)))
//                    I wasn't able to calculate the max value in the same line, so the max value amongst
//                    all the possible profit outcomes is calculated a bit later in the cycle's iteration
                    decisionProfit += probability * (
                            thisMonthPossibleProfit
                                    - monthCosts
                                    + nextMonthSolution.getStateSolution(stateCouchesGot + currentDecisionToOrder - couchesSold).getAverageProfit()
                    );
                }
                else decisionProfit += probability * (couchIncome * couchesSold - monthCosts);
            }
//            get max
            if (decisionProfit > maxProfit) {
//                Wi(Si) = max {SUM(P(Yik)*(c*Qi(Ui,Yik) + Wi+1(Si + Ui - Qi(Ui, Yik)))}
                maxProfit = decisionProfit;
                bestCouchesOrdered = currentDecisionToOrder;
            }
        }
        return new StateSolution(bestCouchesOrdered, maxProfit);
    }
}
