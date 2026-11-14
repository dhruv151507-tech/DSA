class Solution {
    private boolean isvowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int count=0;
        for(int i=0;i<k;i++){
            if(isvowel(s.charAt(i))) count++;
        }
        int maxv=count;
        for(int i=k;i<s.length();i++){
            if(isvowel(s.charAt(i-k))) count--;
            if(isvowel(s.charAt(i))) count++;
            maxv=Math.max(maxv,count);
        }
        return maxv;

    }
}