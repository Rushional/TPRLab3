package Solutions;

public class MonthSolution {
    private StateSolution[] solutionsArray; //array 0-10 of possible states and those states' solutions

    public MonthSolution(StateSolution[] solutionsArray) {
        this.solutionsArray = solutionsArray;
    }

    public StateSolution getStateSolution(int state) {
        return solutionsArray[state];
    }

    public void showResults() {
        for (int stateCouchesGot = 0; stateCouchesGot <= 10; stateCouchesGot++) {
            String couchString;
            String isString;
            if (stateCouchesGot == 1) {
                couchString = " couch";
                isString = "is ";
            }
            else {
                couchString = " couches";
                isString = "are ";
            }
            System.out.println("In case there " + isString + stateCouchesGot + couchString + " stored at the beginning of the month");
            solutionsArray[stateCouchesGot].showResults();
        }
    }
}
