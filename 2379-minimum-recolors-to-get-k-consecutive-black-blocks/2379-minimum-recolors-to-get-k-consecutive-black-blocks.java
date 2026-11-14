class Solution {
    public int minimumRecolors(String blocks, int k) {
        int colorcount=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W')colorcount++;
        }
        int mincolor=colorcount;
        for(int i=k;i<blocks.length();i++){
            if(blocks.charAt(i-k)=='W')colorcount--;
            if(blocks.charAt(i)=='W') colorcount++;
            mincolor=Math.min(mincolor,colorcount);
        }
        return mincolor;
    }
}