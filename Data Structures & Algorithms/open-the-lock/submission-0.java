class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String>dead=new HashSet<>();
        for(String s:deadends){
            dead.add(s);
        }
        if(dead.contains("0000")){
            return -1;
        }
        Queue<String>q=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();

         q.offer("0000");
        visited.add("0000");
        int moves=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(target))
                return moves;
            char[] arr=curr.toCharArray();
            for(int j=0;j<4;j++){
                char original=arr[j];
                char up;
                if(original=='9'){
                    up='0';
                }else{
                    up=(char)(original+1);
                }
                arr[j]=up;
                String next=new String(arr);
                if(!dead.contains(next) && !visited.contains(next)){
                    visited.add(next);
                    q.offer(next);
                }
                 arr[j]=original;

                 char down;
                 if(original == '0'){
                        down = '9';
                    }
                    else{
                        down = (char)(original - 1);
                    }

                    arr[j] = down;

                    next = new String(arr);

                    if(!dead.contains(next) && !visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                    arr[j] = original;
                }
            }
            moves++;
        }
        return -1;

     }
}