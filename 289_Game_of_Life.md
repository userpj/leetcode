According to the [Wikipedia's article](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life): "The **Game of Life**, also known simply as **Life**, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a *board* with *m* by *n* cells, each cell has an initial state *live* (1) or *dead* (0). Each cell interacts with its [eight neighbors](https://en.wikipedia.org/wiki/Moore_neighborhood) (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population..
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

**Follow up**: 

1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
2. In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?



### my answer

题目要求solve it in-place。故添加一位记录期望状态。

00表示死->死。01表示活->死。11表示活->活。10表示死->活。

```java
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null) return;
        int x = board.length;
        int y = board[0].length;
        for(int i = 0;i < x; i++) {
        	for(int j = 0; j < y; j++) {
        		int livesar = lives(board, i, j);
        		if((board[i][j] &1) == 1) {
        			if(livesar > 3 || livesar <2)  board[i][j] = 1;
        			if(livesar == 2 || livesar == 3) board[i][j] = 3;
        		}
        		if((board[i][j] & 1) == 0) {
        			if(livesar == 3) board[i][j] = 2;
        		}
        	}
        }
        
        for(int i = 0; i < x; i++) {
        	for(int j = 0; j <y; j++) {
        		board[i][j] = board[i][j] / 2;
        	}
        }  
    }
	
    private int lives(int[][] board, int x, int y) {
    	int count = 0;
    	for(int i = -1; i <= 1; i++) {
    		for(int j = -1; j <= 1; j++) {
    			if((i|j) != 0 && (x+i >= 0 && x+i < board.length) && (y+j >=0 && y+j <board[0].length)) { //attention array sould < board.length
    				if((board[x+i][y+j] &1) == 1) count++;
    			}
    		}
    	}
    	return count;
    }
}
```

