package Solutions;

public class StateSolution {
    private int couchesOrdered;
    private double averageProfit;

    public StateSolution(int couchesOrdered, double averageProfit) {
        this.couchesOrdered = couchesOrdered;
        this.averageProfit = averageProfit;
    }

    public int getCouchesOrdered() {
        return couchesOrdered;
    }

    public double getAverageProfit() {
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
