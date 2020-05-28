package Solutions;

import static Model.ProbabilityDistribution.getProbability;

public class ProfitCalculator {
    private double calculateMonthExpected(int currentMonth, int couchesGot) {
        double expectedProfit = - couchesGot * 15;
        //decision is static, so:
        if (couchesGot < 3) {
            expectedProfit -= 350; //paying for 1 car to get 2 couches, then paying to hold them for 2 months: 60 + 130*2 + 15*2
            couchesGot += 2;
        }
        for (int maxCouchesSold = 0; maxCouchesSold <= 5; maxCouchesSold++) {
            int couchesSold = Math.min(maxCouchesSold, couchesGot); // can't sell more than there is
            int soldBranchResult = 780 * couchesSold;
            if (currentMonth != 5) {
                soldBranchResult += calculateMonthExpected(
                        currentMonth + 1, couchesGot - couchesSold
                );
            }
            double probability = getProbability(currentMonth, maxCouchesSold);
            expectedProfit += soldBranchResult * probability; //mathematical expectation
        }
        return roundProfit(expectedProfit);
    }

    public void solveFirstTask() {
        for (int startingCouchesGot = 0; startingCouchesGot <= 10; startingCouchesGot++) {
            System.out.println("For " + startingCouchesGot + " couches the profit with the static strategy is " +
                    calculateMonthExpected(0, startingCouchesGot));
        }
    }

    //    Round to 3 decimal places
    private static double roundProfit(double averageProfit) {
        return (double)Math.round(averageProfit*1000)/1000;
    }
}
