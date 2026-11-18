class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        p.offer(new int[]{nums1[0] + nums2[0], 0, 0});

        while (k-- > 0 && !p.isEmpty()) {
            int[] curr = p.poll();
            int i = curr[1], j = curr[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                p.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            if (j == 0 && i + 1 < nums1.length) {
                p.offer(new int[]{nums1[i + 1] + nums2[0], i + 1, 0});
            }
        }

        return ans;
    }
}