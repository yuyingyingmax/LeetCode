package eazy;
/*
第36题 中
 */

public class IsValidSudoku {
    /*
    我的方法：在一次双重循环中判断三种情况
    根据观察发现，如果对3x3的小矩形标号,board[i][j]的对应第 i/3 * 3+ j/3 个小矩形
     */
    public boolean isValidSudoku(char[][] board){
        int[] row = new int[10];//验证行是否有效 大小为10 数组下标代表0-9个数字
        int[][] col = new int[9][10];//验证列是否有效
        int[][] sub_board = new int[9][10];//验证3x3是否有效（一共9个3x3）

        for(int i = 0;i<9;i++){
            row = new int[10];
            for(int j = 0;j<9;j++){
                if(board[i][j]!='.'){
                    if(check(row,board[i][j]-'0')||
                            check(col[j],board[i][j]-'0')||
                            check(sub_board[i/3 *3+j/3],board[i][j]-'0')){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //检查arr中是否存在num
    public boolean check(int[] arr,int num){
        if(arr[num]==1){
            return true;
        }
        arr[num] = 1;
        return false;
    }

    public static void main(String[] args) {
        IsValidSudoku ivs = new IsValidSudoku();
        char[][] board ={
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(ivs.isValidSudoku(board));
    }
}
