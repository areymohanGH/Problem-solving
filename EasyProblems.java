import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EasyProblems {
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

    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                result++;
            n = n >> 1;
        }
        return result;
    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int tSum = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return tSum - sum;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
