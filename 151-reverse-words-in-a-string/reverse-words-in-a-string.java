class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        flip(chars, 0, n - 1);

        int write = 0;
        int read = 0;

        while (read < n) {
            while (read < n && chars[read] == ' ') {
                read++;
            }
            if (read >= n) {
                break;
            }
            if (write > 0) {
                chars[write++] = ' ';
            }
            int wordStart = write;
            while (read < n && chars[read] != ' ') {
                chars[write++] = chars[read++];
            }
            flip(chars, wordStart, write - 1);
        }

        return new String(chars, 0, write);
    }

    private void flip(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}