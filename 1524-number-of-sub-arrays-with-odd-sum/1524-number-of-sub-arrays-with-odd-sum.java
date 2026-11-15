class Solution {
    public int numOfSubarrays(int[] arr) {
        int count=0;
        int mod = 1000000007;
        int prefixsum=0;
        int evencount=1;
        int oddcount=0;

        for(int i=0;i<arr.length;i++){
                prefixsum +=arr[i];
          if(prefixsum%2==0){
            count = (count+oddcount)%mod;
            evencount++;
          }
          else{
            count=(count+evencount)%mod;
            oddcount++;
          }
        }
        return (int)count;
    }
}