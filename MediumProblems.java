public class MediumProblems {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1, postfix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
