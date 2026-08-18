class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=tasks[i][0];
            arr[i][1]=tasks[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[2],b[2]);
        }
        );
        int[] result=new int[n];
        int resultIndex=0;
        int i=0;
        long time=0;
        while(resultIndex<n){
            while (i < n && arr[i][0] <= time) {
                pq.offer(arr[i]);
                i++;
            }
            if (pq.isEmpty()) {
                time = arr[i][0];
                continue;
            }
            int[] current = pq.poll();

            result[resultIndex] = current[2];
            resultIndex++;

            // CPU spends processing time on this task
            time += current[1];
        }
        return result;
    }
}