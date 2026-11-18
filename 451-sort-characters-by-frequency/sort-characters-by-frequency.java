class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()) freq[c]++;

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
            int max = 0, idx = 0;
            for(int i = 0; i < 128; i++) {
                if(freq[i] > max) {
                    max = freq[i];
                    idx = i;
                }
            }
            while(freq[idx]-- > 0) sb.append((char) idx);
        }
        return sb.toString();
    }
}