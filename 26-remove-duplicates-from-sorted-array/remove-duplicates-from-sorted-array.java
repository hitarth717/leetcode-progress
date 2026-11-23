class Solution {
    public int getUniqueCount(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int ind = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[ind] = arr[i];
                ind++;
            }
        }

        return ind;
    }

    public int removeDuplicates(int[] nums) {
        return getUniqueCount(nums);
    }
}