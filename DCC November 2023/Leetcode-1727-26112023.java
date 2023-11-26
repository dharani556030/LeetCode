// Problem Link -> https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int pre[]=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            int temp[]=new int[m];
            for(int j=0;j<m;j++){
               if(matrix[i][j]==0){
                   pre[j]=0;
               }else{
                   pre[j]+=1;
               }
               temp[j]=pre[j];
            }
            Arrays.sort(temp);
            for(int j=0;j<m;j++){
                ans=Math.max(ans,temp[j]*(m-j));
            }
        }
        return ans;
    }
}

