public class Company implements Comparable<Company> {
    private String name;
    private int[] sales;
    private ProfitCalculation calculationMethod;
    private int profit;


    @Override
    public int compareTo(Company o) {
        // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
        if (o.getProfit() < getProfit()) return -1;
        else if (o.getProfit() > getProfit()) return 1;
        else if (sales.length < o.getSales().length) return -1;
        else if (sales.length > o.getSales().length) return 1;
        else return 0;
    }

    public Company(String name, int[] sales, ProfitCalculation calculationMethod) {
        this.name = name;
        this.sales = sales;
        this.calculationMethod = calculationMethod;
        profit = this.calculationMethod.calculateProfit(sales);
    }

    public String getName() {
        return name;
    }

    public int getProfit() {
        return profit;
    }

    public int[] getSales() {
        return sales;
    }

}
