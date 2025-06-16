
public class PublicFirm implements ProfitCalculation {

    @Override
    public int calculateProfit(int[] sales) {
        // throw new UnsupportedOperationException("Unimplemented method 'calculateProfit'");
        int max = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > max) max = sales[i];
        }
        return max;
    }

}
