
class Solution {
    public int minAddToMakeValid(String s) {

        int openBracket = 0;
        int missingBracket = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                openBracket++;
            }
            else if (openBracket > 0) {
                openBracket--;
            }
            else {
                missingBracket++;
            }
        }

        return openBracket + missingBracket;
    }
}
