package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;

import static SolutionSearch.ForState.calculateStateExpected;

public class ForMonth {
    public static MonthSolution calculateMonth(int monthNumber, MonthSolution nextMonthSolution) {
        StateSolution[] solutionsArray = new StateSolution[11];
//        Calculate the best solution for every step and
//        compile a tidy MonthSolution where all the decisions for a single month are kept
        for (int stateCoachesGot = 0; stateCoachesGot <= 10; stateCoachesGot++) {
            solutionsArray[stateCoachesGot] = calculateStateExpected(monthNumber, stateCoachesGot, nextMonthSolution);
        }
        return new MonthSolution(solutionsArray);
    }
}
