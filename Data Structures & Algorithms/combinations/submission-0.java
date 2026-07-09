class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int index,
                       int n,
                       int k,
                       List<Integer> path,
                       List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            helper(i + 1, n, k, path, ans);
            path.remove(path.size() - 1);
        }
    }
}