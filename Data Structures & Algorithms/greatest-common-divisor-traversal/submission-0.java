class Solution {

    int[] parent;

    public boolean canTraverseAllPairs(int[] nums) {

        // If only one number is present
        if (nums.length == 1)
            return true;

        // If any number is 1, it can never connect to others
        for (int num : nums) {
            if (num == 1)
                return false;
        }

        // Find maximum number
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Initialize DSU
        parent = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            parent[i] = i;
        }

        // Prime Factorization + Union
        for (int num : nums) {

            int x = num;

            for (int factor = 2; factor * factor <= x; factor++) {

                if (x % factor == 0) {

                    union(num, factor);

                    while (x % factor == 0) {
                        x /= factor;
                    }
                }
            }

            // Remaining prime factor
            if (x > 1) {
                union(num, x);
            }
        }

        // Check if all numbers belong to same component
        int root = find(nums[0]);

        for (int num : nums) {
            if (find(num) != root)
                return false;
        }

        return true;
    }

    // Find with Path Compression
    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Union
    private void union(int x, int y) {

        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[px] = py;
        }
    }
}