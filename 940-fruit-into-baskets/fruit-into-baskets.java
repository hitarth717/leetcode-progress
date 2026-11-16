public class Solution {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] count = new int[n + 1];
        int start = 0;
        int dist = 0;
        int ans = 0;
        
        for (int end = 0; end < n; end++) {
            if (count[fruits[end]] == 0) {
                dist++;
            }
            count[fruits[end]]++;
            
            while (dist > 2) {
                count[fruits[start]]--;
                if (count[fruits[start]] == 0) {
                    dist--;
                }
                start++;
            }
            
            ans = Math.max(ans, end - start + 1);
        }
        
        return ans;
    }
}