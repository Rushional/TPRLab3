import Model.ProfitCalculator;

public class Main {

    public static void main(String[] args) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        System.out.println("initially 0: " + profitCalculator.calculateMonthExpected(0, 0, 0));
        System.out.println("initially 1: " + profitCalculator.calculateMonthExpected(0, 1, 0));
        System.out.println("initially 2: " + profitCalculator.calculateMonthExpected(0, 2, 0));
        System.out.println("initially 3: " + profitCalculator.calculateMonthExpected(0, 3, 0));
    }
}
