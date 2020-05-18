package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;

import static SolutionSearch.ForState.calculateLastStateExpected;

public class ForMonth {
    public static MonthSolution calculateLastMonth() {
        StateSolution[] solutionsArray = new StateSolution[11];
        for (int stateCoachesGot = 0; stateCoachesGot <= 10; stateCoachesGot++) {
            //make solution for 1 state
//            Optionally I'll make a "get max method" to have a formula in 1 line
//            But that's a low priority
            solutionsArray[stateCoachesGot] = calculateLastStateExpected(stateCoachesGot);
        }
        return new MonthSolution(solutionsArray);
//        return solutionsArray;
    }
}
