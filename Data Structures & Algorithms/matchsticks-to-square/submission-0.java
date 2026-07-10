class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int x : matchsticks) {
            sum += x;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);

        // Descending order
        int l = 0;
        int r = matchsticks.length - 1;

        while (l < r) {
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
            l++;
            r--;
        }

        boolean[] visited = new boolean[matchsticks.length];

        return helper(matchsticks,
                      visited,
                      0,
                      4,
                      0,
                      target);
    }

    public boolean helper(int[] matchsticks,
                          boolean[] visited,
                          int start,
                          int sides,
                          int current,
                          int target) {

        if (sides == 1) {
            return true;
        }

        if (current == target) {
            return helper(matchsticks,
                          visited,
                          0,
                          sides - 1,
                          0,
                          target);
        }

        for (int i = start; i < matchsticks.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (current + matchsticks[i] > target) {
                continue;
            }

            visited[i] = true;

            if (helper(matchsticks,
                       visited,
                       i + 1,
                       sides,
                       current + matchsticks[i],
                       target)) {

                return true;
            }

            visited[i] = false;
        }

        return false;
    }
}