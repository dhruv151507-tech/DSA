class Solution {
    public int minOperations(String s) {
        int n=s.length();
         boolean issort=true;

         for(int i=1;i<n;i++){
            if(s.charAt(i)<s.charAt(i-1)) {
                issort=false;
                break;}
         }
         if(issort) return 0;
         if(n==2) return -1;
char mini= s.charAt(0);
char maxi=s.charAt(0);
         for(int i=1;i<n;i++){
            mini=(char) Math.min(mini,s.charAt(i));
            maxi=(char) Math.max(maxi,s.charAt(i));
         }

         if(s.charAt(0)==mini ||s.charAt(n-1)==maxi) return 1;
         for(int i=1;i<n-1;i++){
            if(s.charAt(i)==mini || s.charAt(i)==maxi) return 2;
         }
         return 3;
    }
}