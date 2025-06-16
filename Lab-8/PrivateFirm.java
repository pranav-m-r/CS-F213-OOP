
public class PrivateFirm implements ProfitCalculation {

    @Override
    public int calculateProfit(int[] sales) {
        // throw new UnsupportedOperationException("Unimplemented method 'calculateProfit'");
        int max = 0;
        for (int i = 0; i < sales.length; i++) {
            int sum = 0;
            for (int j = i; j < sales.length; j++) {
                sum += sales[j];
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    
}
