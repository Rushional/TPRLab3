package SolutionSearch;

import Solutions.StateSolution;
import org.junit.jupiter.api.Test;

import static SolutionSearch.ForState.calculateStateExpected;
import static org.junit.jupiter.api.Assertions.*;

class ForStateTest {

    @Test
    void calculateLastStateExpectedTest() {
        StateSolution solutionFrom8 = calculateStateExpected(5, 8, null);
        assertEquals(0, solutionFrom8.getCouchesOrdered());
        assertEquals(2142, solutionFrom8.getAverageProfit());
    }
}