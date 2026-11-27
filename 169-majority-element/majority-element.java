class Solution {
    public int majorityElement(int[] nums) {
        int a1 = 0;
        int a2 = 0;

        for (int val : nums) {
            if (a2 == 0) {
                a1 = val;
            }
            a2 += (val == a1) ? 1 : -1;
        }

        return a1;
    }
}