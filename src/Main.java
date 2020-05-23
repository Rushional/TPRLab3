//import Solutions.MonthSolution;
import Model.ProfitCalculator;
import Solutions.TaskSolution;

//import static SolutionSearch.ForMonth.calculateMonth;
import static SolutionSearch.ForTask.calculateTask;

public class Main {
    public static void main(String[] args) {
//        MonthSolution lastMonthSolution = calculateMonth(5, null);
//        lastMonthSolution.showResults();
//        TaskSolution taskSolution = calculateTask();
//        taskSolution.showResults();
        ProfitCalculator b = new ProfitCalculator();
        for (int startingCouchesGot = 0; startingCouchesGot <= 10; startingCouchesGot++) {
            System.out.println("For " + startingCouchesGot + " couches the profit with the static strategy is " +
                    b.calculateMonthExpected(0, startingCouchesGot));
        }
    }
}
