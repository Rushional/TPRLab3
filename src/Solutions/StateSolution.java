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
}
