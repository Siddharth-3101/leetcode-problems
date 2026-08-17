class Solution {
    int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};
    public boolean dfs(char[][] board,String word,int row,int col,int index){
        if(word.length()==index){
            return true;
        }
        if(row<0 || row>=board.length || col<0 || col>=board[0].length||board[row][col]!=word.charAt(index)){
            return false;
        }
        char temp=board[row][col];
        board[row][col]='.';
        for(int[] dir:direction){
            int r=row+dir[0];
            int c=col+dir[1];
            if(dfs(board,word,r,c,index+1)){
                board[row][col]=temp;
                return true;
            }
        }
        board[row][col]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}