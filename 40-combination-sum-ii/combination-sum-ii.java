class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        res = new ArrayList<>();
        Arrays.sort(arr);
        dfs(arr, target, 0, new int[arr.length], 0);
        return res;
    }

    void dfs(int[] arr, int t, int ind, int[] path, int len) {
        if(t == 0) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < len; i++) temp.add(path[i]);
            res.add(temp);
            return;
        }
        for(int i = ind; i < arr.length; i++) {
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > t) break;
            path[len] = arr[i];
            dfs(arr, t - arr[i], i + 1, path, len + 1);
        }
    }
}