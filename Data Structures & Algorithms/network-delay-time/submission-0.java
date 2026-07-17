class Solution {
    class Pair{
        int node;
        int weight;

        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<Pair>> graph=new HashMap<>();
        for(int i=0;i<times.length;i++){
            int source=times[i][0];
            int dest=times[i][1];
            int weight=times[i][2];
            if(!graph.containsKey(source)){
                graph.put(source,new ArrayList<>());
            }
            graph.get(source).add(new Pair(dest,weight));
        }
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[k]=0;
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.offer(new Pair(k, 0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int currDistance=curr.weight;


            if (currDistance > distance[node])
                continue;

            if (!graph.containsKey(node))
                continue;

                for(Pair neighbour:graph.get(node)){
                    int nextNode=neighbour.node;
                    int edgeWeight=neighbour.weight;
                    int newDistance=currDistance+edgeWeight;
                    if (newDistance < distance[nextNode]) {

                    distance[nextNode] = newDistance;

                    pq.offer(new Pair(nextNode, newDistance));
                }
            }

        }
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i] == Integer.MAX_VALUE)
                return -1;

            answer = Math.max(answer, distance[i]);
        }

        return answer;
    }
}
