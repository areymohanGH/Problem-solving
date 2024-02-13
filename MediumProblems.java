public class MediumProblems {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            totalProduct *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            nums[i] = totalProduct / nums[i];
        }
        return nums;
    }
}
