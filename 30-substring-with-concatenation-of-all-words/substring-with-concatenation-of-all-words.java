class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return ans;
        }

        int w = words[0].length();
        int total = words.length;
        int wl = w * total;
        int n = s.length();

        Map<String, Integer> need = new HashMap<>();
        for (String item : words) {
            need.put(item, need.getOrDefault(item, 0) + 1);
        }

        for (int start = 0; start < w; start++) {
            int left = start;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = start; right + w <= n; right += w) {
                String part = s.substring(right, right + w);

                int target = need.getOrDefault(part, 0);
                if (target == 0) {
                    seen.clear();
                    count = 0;
                    left = right + w;
                    continue;
                }

                int used = seen.getOrDefault(part, 0) + 1;
                seen.put(part, used);
                count++;

                while (used > target) {
                    String drop = s.substring(left, left + w);
                    seen.put(drop, seen.get(drop) - 1);
                    used = seen.getOrDefault(part, 0);
                    count--;
                    left += w;
                }

                if (count == total) {
                    ans.add(left);
                    String drop = s.substring(left, left + w);
                    seen.put(drop, seen.get(drop) - 1);
                    count--;
                    left += w;
                }
            }
        }

        return ans;
    }
}