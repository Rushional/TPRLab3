import Model.ProfitCalculator;
import Solutions.StateSolution;

import static SolutionSearch.ForState.calculateLastStateExpected;

public class Main {
    public static void main(String[] args) {
//        ProfitCalculator profitCalculator = new ProfitCalculator();
//        System.out.println("initially 3: " + profitCalculator.calculateMonthExpected(0, 3, 0));
//        System.out.println("initially 4: " + profitCalculator.calculateMonthExpected(0, 4, 0));
//        System.out.println("initially 5: " + profitCalculator.calculateMonthExpected(0, 5, 0));
//        System.out.println("initially 6: " + profitCalculator.calculateMonthExpected(0, 6, 0));
        StateSolution solutionFrom8 = calculateLastStateExpected(8);
        System.out.println(solutionFrom8.getCouchesOrdered() + ", " + solutionFrom8.getAverageProfit());
        StateSolution solutionFrom0 = calculateLastStateExpected(0);
        System.out.println(solutionFrom0.getCouchesOrdered() + ", " + solutionFrom0.getAverageProfit());
        StateSolution solutionFrom1 = calculateLastStateExpected(1);
        System.out.println(solutionFrom1.getCouchesOrdered() + ", " + solutionFrom1.getAverageProfit());
        StateSolution solutionFrom2 = calculateLastStateExpected(2);
        System.out.println(solutionFrom2.getCouchesOrdered() + ", " + solutionFrom2.getAverageProfit());
        StateSolution solutionFrom3 = calculateLastStateExpected(3);
        System.out.println(solutionFrom3.getCouchesOrdered() + ", " + solutionFrom3.getAverageProfit());
        StateSolution solutionFrom4 = calculateLastStateExpected(4);
        System.out.println(solutionFrom4.getCouchesOrdered() + ", " + solutionFrom4.getAverageProfit());


    }
}
