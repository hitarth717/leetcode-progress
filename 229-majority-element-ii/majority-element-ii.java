class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, c = 0, d = 0;

        for (int num : nums) {
            if (num == a) {
                c++;
            } else if (num == b) {
                d++;
            } else if (c == 0) {
                a = num;
                c = 1;
            } else if (d == 0) {
                b = num;
                d = 1;
            } else {
                c--;
                d--;
            }
        }

        c = 0;
        d = 0;
        for (int num : nums) {
            if (num == a) c++;
            else if (num == b) d++;
        }

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (c > n / 3) ans.add(a);
        if (d > n / 3) ans.add(b);

        return ans;
    }
}