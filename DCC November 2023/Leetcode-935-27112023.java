// Problem Link -> https://leetcode.com/problems/knight-dialer/description/

class Solution {
    int dp[][];
    public int knightDialer(int n) {
    int count=0;
    int k= 1000000007; 
    dp=new int[n+1][12];
    for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
      for(int i=0;i<12;i++){
          count = (count +solve(n,i))%k;
      }
      return count;
    }

    public int solve(int n, int num){
        int r=num/3,c=num%3;
        int row[]={-2,-2,-1,-1,1,1,2,2};
        int col[]={-1,1,-2,2,-2,2,-1,1};
        int dailpad[][]={{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};

        if(dailpad[r][c]==-1){
            dp[n][num]=0;
            return 0;
            }
        if(dp[n][num]!=-1)return dp[n][num];
        if(n==1){
            dp[n][num]=1;
            return 1;
        }
        int count=0;
        int k= 1000000007;
        for(int i=0;i<row.length;i++){
            int nr=r+row[i];
            int nc=c+col[i];
            if(nr<0 || nr>3 || nc<0 || nc>2)continue;
            if(dailpad[nr][nc]==-1)continue;
            count = (count + solve(n-1,nr*3+nc))%k;
        }
        dp[n][num]=count;
    return count;
    }
}