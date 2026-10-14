class Solution {
public:
    string maxSumOfSquares(int num, int sum) {
        if(num*9<sum) return "";
        int nines= sum/9;
        int remaining=sum%9;
        string ans (nines, '9');
        if(remaining>0) ans.push_back(remaining+'0');
        ans.append(num - ans.length(),'0');
        return ans;

    }
};