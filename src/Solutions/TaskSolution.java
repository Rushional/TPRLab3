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
}
