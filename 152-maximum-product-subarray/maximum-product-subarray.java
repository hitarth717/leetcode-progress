class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int Max = nums[0];
        int Min = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                int temp = Max;
                Max = Min;
                Min = temp;
            }

            Max = Math.max(num,Max * num);
            Min = Math.min(num,Min * num);
            maxProduct = Math.max(maxProduct,Max);
        }

        return maxProduct;
    }
}