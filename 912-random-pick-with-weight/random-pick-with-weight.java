import java.util.Random;

class Solution {
    private int[] runningSums;
    private Random random;

    public Solution(int[] w) {
        runningSums = new int[w.length];
        runningSums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            runningSums[i] = runningSums[i - 1] + w[i];
        }
        random = new Random();
    }
    
    public int pickIndex() {
        int total = runningSums[runningSums.length - 1];
        int target = random.nextInt(total) + 1;
        
        int left = 0;
        int right = runningSums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (runningSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */