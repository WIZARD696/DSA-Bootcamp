class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char [][] board){
        int n=board.length;
        int row=-1;
        int col=-1;

        boolean emptyLeft=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                }
            }
            if(emptyLeft==false){
                break;
            }
        }

        if(emptyLeft==true){
            return true;
        }

        for(char number='1';number<='9';number++){
            if(isSafe(board,row,col,number)){
                board[row][col]=number;
                if(solve(board)){
                    return true;
                }
                else{
                    //backtrack
                    board[row][col]='.';
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][]board,int row,int col,char ch){
        
        //row check
        for(int i=0;i<board.length;i++){
            if(board[row][i]==ch){
                return false;
            }
        }

        //column check
        for(char[]arr:board){
            if(arr[col]==ch){
                return false;
            }
        }

        int sqrt=(int)Math.sqrt(board.length);
        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;

        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }

        return true;
    }
}