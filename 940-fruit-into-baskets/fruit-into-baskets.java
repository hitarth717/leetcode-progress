public class Solution {

    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxFruits = 0;
        int uniqueTypes = 0;
        int[] counts = new int[fruits.length + 1];
        
        for (int right = 0; right < fruits.length; right++) {
            if (counts[fruits[right]] == 0) {
                uniqueTypes++;
            }
            counts[fruits[right]]++;
            
            while (uniqueTypes > 2) {
                counts[fruits[left]]--;
                if (counts[fruits[left]] == 0) {
                    uniqueTypes--;
                }
                left++;
            }
            
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}