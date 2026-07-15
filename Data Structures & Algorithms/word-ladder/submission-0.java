class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>wordset=new HashSet<>(wordList);
        if(!wordset.contains(endWord)){
            return 0;
        }
        Queue<String>q=new LinkedList<>();
        HashSet<String>visited=new HashSet<>();
         q.offer(beginWord);
         visited.add(beginWord);
         int level=1;
         while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(endWord)){
                    return level;
                }
                char[] arr=curr.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        if(ch==original){
                            continue;
                        }
                        arr[j]=ch;
                        String next=new String(arr);
                        if(wordset.contains(next)&& !visited.contains(next)){
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    arr[j]=original;

                }
            }
            level++;
         }
         return 0;
    }
}
