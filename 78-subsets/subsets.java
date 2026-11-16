import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        build(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void build(int idx, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            build(i + 1, nums, path, ans);
            path.remove(path.size() - 1);
        }
    }
}