package Model;

import static Model.ProbabilityDistribution.getProbability;

public class ProfitCalculator {
    public double calculateMonthExpected(int currentMonth, int couchesGot, int moneyGot) {
        int resultMoney = moneyGot - couchesGot * 15;
        //decision is static, so:
        resultMoney -= 350; //paying for 1 car to get 2 sofas, then paying to hold them for 2 months: 60 + 130*2 + 15*2
        couchesGot += 2;
        double expected = moneyGot;
        for (int maxCouchesSold = 0; maxCouchesSold <= 5; maxCouchesSold++) {
            int couchesSold = Math.min(maxCouchesSold, couchesGot);
            int soldBranchResult = 780 * couchesSold;
            if (currentMonth != 5) {
                soldBranchResult += calculateMonthExpected(
                        currentMonth + 1, couchesGot, resultMoney
                );
            }
            double probability = getProbability(currentMonth, maxCouchesSold);
            expected += soldBranchResult * probability;
        }
        return expected;
    }
}
