class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            String first=words[i];
            String second=words[i+1];
            int len=Math.min(first.length(),second.length());
            boolean founddiff=false;
            for(int j=0;j<len;j++){
                char c1=first.charAt(j);
                char c2=second.charAt(j);
                if(c1!=c2){
                    founddiff=true;
                    if(map.get(c1)>map.get(c2)){
                        return false;
                    }
                    break;
                }
            }
            if(!founddiff && first.length()>second.length()){
                return false;
            }
        }
        return true;
    }
}