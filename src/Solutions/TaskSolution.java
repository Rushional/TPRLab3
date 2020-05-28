package Solutions;

public class TaskSolution {
    private MonthSolution[] solutionsArray;


    public TaskSolution(MonthSolution[] solutionsArray) {
        this.solutionsArray = solutionsArray;
    }

    public MonthSolution[] getSolutionsArray() {
        return solutionsArray;
    }

    public void showResults() {
        for (int currentMonth = 0; currentMonth <= 5; currentMonth++) {
            System.out.println("For month " + (currentMonth + 1) + " the choices should be: ");
            solutionsArray[currentMonth].showResults();
            System.out.print("\n \n \n");
        }
    }

    public void showTableDecisions() {
        System.out.println("Rows are states (how many couches there is at the start of the month)");
        System.out.println("Columns are months");
        for (int stateCouchesGot = 0; stateCouchesGot <= 10; stateCouchesGot++) {
            for (int currentMonth = 0; currentMonth <= 5; currentMonth++) {
                int currentDecision = solutionsArray[currentMonth].
                        getStateSolution(stateCouchesGot).getCouchesOrdered();
                System.out.print(currentDecision + " ");
            }
            System.out.println();
        }
    }
}
