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
        System.out.println("This will gain " + roundProfit(averageProfit) + " on average");
    }

    //    Round to 3 decimal places
    private static double roundProfit(double averageProfit) {
        return (double)Math.round(averageProfit*1000)/1000;
    }
}
