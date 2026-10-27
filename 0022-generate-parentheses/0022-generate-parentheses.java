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
    private void solve(int index, StringBuilder temp, int len){
        if(index==len){
            String s= temp.toString();
            if(isvalid(s)) {
                
                ans.add(s);
            }
            return;
        }

        temp.append('(');
        solve(index+1,temp ,len);
        temp.deleteCharAt(temp.length()-1);

        temp.append(')');
        solve(index+1,temp,len);
        temp.deleteCharAt(temp.length()-1);
    }
    public List<String> generateParenthesis(int n) {
       ans.clear();
        solve(0,new StringBuilder(),2*n);
        return ans;
    }
}