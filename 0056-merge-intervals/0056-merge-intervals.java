class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<=1) return intervals;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
        int[] curr=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int nexts=intervals[i][0];
            int nexte=intervals[i][1];
            if(curr[1]>=nexts) curr[1]=Math.max(curr[1],nexte);
            else{
                ans.add(curr);
                curr=intervals[i];
            }
        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][]);
    }
}