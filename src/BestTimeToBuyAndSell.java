import java.util.Arrays;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        printPrices(prices);
        SolutionStock solution = new SolutionStock();
        System.out.println(solution.maxProfit(prices));


    }
    public static void printPrices(int[] prices){
        StringBuffer sb = new StringBuffer();
        sb.append("prices = [");
        Arrays.stream(prices).forEach(i->sb.append(Integer.toString(i) + ","));
        sb.append("} ");
    }
}

class SolutionStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            if(prices[i] - minPrice >= maxProfit) maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }
}
