package SolutionSearch;

import Solutions.StateSolution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForMonthTest {
    //Yeah, it doesn't test it all, so this is not the best test
    @Test
    void lastMonthSolution() {
        StateSolution stateSolution = ForMonth.calculateLastMonth().getStateSolution(8);
        assertEquals(0, stateSolution.getCouchesOrdered());
        assertEquals(2142, stateSolution.getAverageProfit());
    }
}