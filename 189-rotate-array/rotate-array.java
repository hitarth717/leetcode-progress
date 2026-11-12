class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        reverseArray(nums, 0, len - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, len - 1);
    }

    private void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int swap = arr[start];
            arr[start] = arr[end];
            arr[end] = swap;
            
            start++;
            end--;
        }
    }
}
