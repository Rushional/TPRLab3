package Solutions;

public class StateSolution {
    private int couchesOrdered;
    private int averageProfit;

    public StateSolution(int couchesOrdered, int averageProfit) {
        this.couchesOrdered = couchesOrdered;
        this.averageProfit = averageProfit;
    }

    public int getCouchesOrdered() {
        return couchesOrdered;
    }

    public int getAverageProfit() {
        return averageProfit;
    }

    public void showResults() {
        String couchString;
        if (couchesOrdered == 1) couchString = " couch";
        else couchString = " couches";
        System.out.println("Order " + couchesOrdered + couchString);
        System.out.println("This will gain " + averageProfit + " on average");
    }
}
