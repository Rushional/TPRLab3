import Solutions.TaskSolution;

import static SolutionSearch.ForTask.calculateTask;

public class Main {
    public static void main(String[] args) {
//        MonthSolution lastMonthSolution = calculateMonth(5, null);
//        lastMonthSolution.showResults();
        TaskSolution taskSolution = calculateTask();
        taskSolution.showResults();
    }
}
