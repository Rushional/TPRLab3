package SolutionSearch;

import Solutions.MonthSolution;
import Solutions.StateSolution;
import org.junit.jupiter.api.Test;

import static SolutionSearch.ForState.calculateStateExpected;
import static org.junit.jupiter.api.Assertions.*;

class ForStateTest {

    @Test
    void calculateStateExpectedTest() {
        StateSolution solutionFrom0 = calculateStateExpected(5, 0, null);
        assertEquals(4, solutionFrom0.getCouchesOrdered());
        assertEquals(1484, solutionFrom0.getAverageProfit());
        StateSolution solutionFrom1 = calculateStateExpected(5, 1, null);
        assertEquals(3, solutionFrom1.getCouchesOrdered());
        assertEquals(1614, solutionFrom1.getAverageProfit());
        StateSolution solutionFrom2 = calculateStateExpected(5, 2, null);
        assertEquals(2, solutionFrom2.getCouchesOrdered());
        assertEquals(1804, solutionFrom2.getAverageProfit());
        StateSolution solutionFrom8 = calculateStateExpected(5, 8, null);
        assertEquals(0, solutionFrom8.getCouchesOrdered());
        assertEquals(2142, solutionFrom8.getAverageProfit());
        StateSolution[] month5TestStates = {
                new StateSolution(4, 1484),
                new StateSolution(3, 1614),
                new StateSolution(2, 1804),
                new StateSolution(1, 1934),
                new StateSolution(0, 2124),
                new StateSolution(0, 2187),
                new StateSolution(0, 2172),
                new StateSolution(0, 2157),
                new StateSolution(0, 2142),
                new StateSolution(0, 2127),
                new StateSolution(0, 2112)
        };
        MonthSolution month5TestSolution = new MonthSolution(month5TestStates);
        StateSolution solutionM5St0 = calculateStateExpected(4, 0, month5TestSolution);
        assertEquals(5, solutionM5St0.getCouchesOrdered());
        assertEquals(3155, (int)(solutionM5St0.getAverageProfit()));
    }
}