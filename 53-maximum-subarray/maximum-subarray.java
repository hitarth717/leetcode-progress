class Solution {
    public int maxSubArray(int[] nums) {
        int presentsum = nums[0];
        int avgsum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (presentsum < 0) {
                presentsum = num;
            } else {
                presentsum += num;
            }

            if (presentsum > avgsum) {
                avgsum = presentsum;
            }
        }

        return avgsum;
    }
}