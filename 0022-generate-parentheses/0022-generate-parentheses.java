class Solution {

    List<String> ans=new ArrayList<>();
    boolean isvalid(String temp){
        int count=0;
        for(int i=0;i<temp.length();i++){
            if(count<0) return false;
            else if(temp.charAt(i)=='(') count++;
            else count--;
        }
        return count==0;
    }
    private void solve(int index, String temp, int len){
        if(index==len){
            if(isvalid(temp)) {ans.add(temp);
            }
            return;
        }

        
        solve(index+1,temp + '(',len);
        solve(index+1,temp + ')',len);
    }
    public List<String> generateParenthesis(int n) {
       ans.clear();
        solve(0,"",2*n);
        return ans;
    }
}