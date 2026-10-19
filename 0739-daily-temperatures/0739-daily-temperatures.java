import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans = new int[n];
       Stack<Integer>st= new Stack<Integer>(); 
        for(int i=0;i<n;i++){
           while(!st.empty() && temperatures[i]>temperatures[st.peek()]){ 
            ans[st.peek()]=i-st.peek();
            st.pop();
            }
           st.push(i);
        }
        return ans;
    }
}