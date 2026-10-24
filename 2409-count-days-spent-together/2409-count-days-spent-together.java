class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a = convert(arriveAlice);
        int b=convert(leaveAlice);
        int c=convert(arriveBob);
        int d=convert(leaveBob);

        int result = Math.max(0,Math.min(b,d) - Math.max(a,c)+1) ;
        return result;
    }

    private int convert(String date){
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int month=Integer.parseInt(date.substring(0,2));
          int day=Integer.parseInt(date.substring(3,5));
          int total=day;
          for(int i=0;i<month-1;i++){
            total +=days[i];
          }
          return total;
    }
}