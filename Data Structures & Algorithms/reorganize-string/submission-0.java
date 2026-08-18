class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<int[]>p1=new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));
        for(Map.Entry<Character,Integer>entry : map.entrySet()){
            p1.offer(new int[]{entry.getKey(),entry.getValue()}
            );

        }
        StringBuilder result=new StringBuilder();
        int[] previous=null;
        while(!p1.isEmpty()){
            int[] current = p1.poll();

            // 5. Add it to result
            result.append((char) current[0]);

            // 6. Use one occurrence
            current[1]--;

            // 7. Put previous character back into heap
            if (previous != null && previous[1] > 0) {
                p1.offer(previous);
            }

            // 8. Current becomes previous
            previous = current;
        }
         if (result.length() != s.length()) {
            return "";
        }
          return result.toString();
    }
}