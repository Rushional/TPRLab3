package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.TaskSolution;

import static SolutionSearch.ForMonth.calculateMonth;

public class ForTask {
    public static TaskSolution calculateTask() {
        MonthSolution[] taskArray = new MonthSolution[6];
        for (int currentMonth = 5; currentMonth >= 0; currentMonth--) {
            MonthSolution currentMonthSolution;
            if (currentMonth == 5) currentMonthSolution = calculateMonth(currentMonth, null);
            else currentMonthSolution = calculateMonth(currentMonth, taskArray[currentMonth+1]);
            taskArray[currentMonth] = currentMonthSolution;
        }
        return new TaskSolution(taskArray);
    }
}
