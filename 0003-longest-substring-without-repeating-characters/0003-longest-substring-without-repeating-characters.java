class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        int j=0;
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(mp.containsKey(c) && mp.get(c)>=j){
               j=mp.get(c)+1;
            }
            mp.put(c,i);
            len=Math.max(len,i-j+1);
        }
        return len;
    }
}