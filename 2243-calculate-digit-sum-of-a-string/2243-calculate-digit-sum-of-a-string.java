class Solution {
    public String digitSum(String s, int k) {
       while(s.length()>k){
        StringBuilder window=new StringBuilder();
        for(int i=0;i<s.length();i +=k){
            int e=Math.min(i+k,s.length());
            String temp= s.substring(i,e);
            int sum=0;
            for(int j=0;j<temp.length();j++){
                sum +=temp.charAt(j)-'0';
            }
            window.append(sum);
        }
        s=window.toString();
       }
       return s;
    }
}