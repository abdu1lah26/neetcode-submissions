class Solution {
    int[] delrow={-1,0,1,0};
    int[] delcol={0,1,0,-1};
    private void dfs(char[][] board,int[][] visted,int row,int col){
        int n=board.length;
        int m=board[0].length;
        visted[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visted[nrow][ncol]!=1 && board[nrow][ncol]=='O'){
                dfs(board,visted,nrow,ncol);
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visted=new int[n][m];
        for(int i=0;i<m;i++){
            if(board[0][i]=='O'&& visted[0][i]==0){
                dfs(board,visted,0,i);
            }
            if(board[n-1][i]=='O'&&visted[n-1][i]==0){
                dfs(board,visted,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'&& visted[i][0]==0){
                dfs(board,visted,i,0);            
            }
            if(board[i][m-1]=='O'&& visted[i][m-1]==0){
                dfs(board,visted,i,m-1);
            }
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&&visted[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        
    }
}