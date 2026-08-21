class Solution {
    int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    public boolean dfs(char[][] board,String word,int row,int col,int index){
        int m=board.length;
        int n=board[0].length;
        if(word.length()==index){return true;}
        if(row<0||row>=m||col<0||col>=n || board[row][col]!=word.charAt(index)){return false;}
        char temp=board[row][col];
        board[row][col]='.';
        for(int[] dir:direction){
            int nr=row+dir[0];
            int nc=col+dir[1];
            if(dfs(board,word,nr,nc,index+1)){
                board[row][col]=temp;
                return true;
            }
        }
        board[row][col]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
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