class Solution {
    public String getPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        String small = arr[0];
        String large = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(small) < 0) {
                small = arr[i];
            } else if (arr[i].compareTo(large) > 0) {
                large = arr[i];
            }
        }

        int ind = 0;
        int len = Math.min(small.length(), large.length());
        while (ind < len && small.charAt(ind) == large.charAt(ind)) {
            ind++;
        }

        return small.substring(0, ind);
    }

    public String longestCommonPrefix(String[] strs) {
        return getPrefix(strs);
    }
}