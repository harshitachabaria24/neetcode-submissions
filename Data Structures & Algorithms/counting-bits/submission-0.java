class Solution {
    public int[] countBits(int n) {
        int[] bits=new int[n+1];
        for(int i=0;i<=n;i++){
            int x=i;
            while(x!=0){
                x=x&(x-1);
                bits[i]++;
            }
        }
        return bits;
    }
}
