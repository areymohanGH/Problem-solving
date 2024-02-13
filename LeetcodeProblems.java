import java.util.HashMap;
import java.util.Map;

public class LeetcodeProblems {
    public static void main(String[] args) {
        LeetcodeProblems object = new LeetcodeProblems();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int a = object.maxProfit(prices);
        System.out.println(a);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (visitedNumbers.containsKey(ans)) {
                return new int[] { i, visitedNumbers.get(ans) };
            }
            visitedNumbers.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public int maxProfit(int[] prices) {
        // Least stock price
        // Profit if sold that day
        // Max profit
        int leastStockPrice = Integer.MAX_VALUE;
        int profitIfSoldThatDay = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            leastStockPrice = prices[i] < leastStockPrice ? prices[i] : leastStockPrice;
            profitIfSoldThatDay = prices[i] - leastStockPrice;
            maxProfit = Math.max(maxProfit, profitIfSoldThatDay);
        }
        return maxProfit;
    }
}