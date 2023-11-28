// Problem Link -> https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/

class Solution {
    public int numberOfWays(String corridor) {
        long ans=1;int k=1000000007;
        int count=0;int st=0,total=0;
        for(int i=0;i<corridor.length();i++){
           if(corridor.charAt(i)=='S'){
               count++;
               if(count==2)st=i;
               if(count==3){
                   ans= (ans*(i-st))%k;
                   count=1;
               }
               total++;
           }
        }

        if(count==1 || total==0)return 0;
        return (int)ans;

    }
}