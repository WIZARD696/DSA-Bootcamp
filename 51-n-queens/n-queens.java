class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean [][] board=new boolean[n][n];
        List<List<String>> ans=new ArrayList<>();
        queens(board,0,ans);
        return ans;
    }
    public void queens(boolean [][] board,int row,List<List<String>> ans){
        if(row==board.length){
            ans.add(display(board));
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                queens(board,row+1,ans);
                board[row][col]=false;//after function call we bactrack our changes
            }
        }
    }
    public boolean isSafe(boolean[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){//we are now travelling in diagonal side so we need to subtact so we start from 1
            if(board[row-i][col-i]){
                return false;
            }
        }

        int maxRight=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){//we are now travelling in diagonal side so we need to subtact so we start from 1
            if(board[row-i][col+i]){//keep your mind open for these changes
                return false;
            }
        }

        return true;
    }

    public List<String> display(boolean[][] board){
        List<String> list=new ArrayList<>();
        for(boolean []arr:board){
            StringBuilder sb=new StringBuilder();
            for(boolean element:arr){
                if(element){
                    sb.append('Q');
                }
                else{
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}