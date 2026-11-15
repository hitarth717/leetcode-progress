public class Solution {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        
        if (length <= 2) {
            return length;
        }
        
        int writeIndex = 2;
        
        for (int readIndex = 2; readIndex < length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
}