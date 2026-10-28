class Solution {
    public int minInsertions(String s) {
        int left=0;
    
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            else {
                if(i+1<s.length() && s.charAt(i+1)==')') i++;

                else ans++;

                if(left>0) left--;
                else ans++;
            }
          
        }
        ans +=left*2;
        return ans;
    }
}