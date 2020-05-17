package SolutionSearch;

import Solutions.StateSolution;
import org.junit.jupiter.api.Test;

import static SolutionSearch.ForState.calculateLastStateExpected;
import static org.junit.jupiter.api.Assertions.*;

class ForStateTest {

    @Test
    void calculateLastStateExpectedTest() {
        StateSolution solutionFrom8 = calculateLastStateExpected(8);
        assertEquals(0, solutionFrom8.getCouchesOrdered());
        assertEquals(2142, solutionFrom8.getAverageProfit());
    }
}