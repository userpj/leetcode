The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

**Note:**
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

**题意**

判断数独是否合法。不要求数独有解。保证题目每行、每列、3*3(共9个)没有重复数字即可。

### my answer

```java
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] num = new int[10];
        for(int i=0; i<9; i++) { //判断每行
            num = new int[10];
            for(int j=0; j<9; j++) {
                if(board[i][j]>='1' && board[i][j]<='9') {
                    num[board[i][j]-'0']++;
                    if(num[board[i][j]-'0'] > 1) return false;
                }else if(board[i][j]!= '.') {
                    return false;
                }
            }
        }
        
        for(int i=0; i<9; i++) { //判断每列
            num = new int[10];
            for(int j=0; j<9; j++) {
                if(board[j][i]>='1' && board[j][i]<='9') {
                    num[board[j][i]-'0']++;
                    if(num[board[j][i]-'0'] > 1) return false;
                }else if(board[j][i]!= '.') {
                    return false;
                }
            }
        }
        
        for(int k=0; k<9; k++) {
            num = new int[10];
            for(int p=0; p<3; p++) {
                for(int q=0; q<3; q++) {
                    int i = p+3*(k/3), j=q+3*(k%3); 
                  //3*(k/3)  000 111 222
                  //3*(k%3)  012 012 012
                    if(board[i][j]>='1' && board[i][j]<='9') {
                        num[board[i][j]-'0']++;
                        if(num[board[i][j]-'0'] > 1) return false;
                    }else if(board[i][j]!= '.') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
```

重复代码太多。。。

set

```java
public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
```

