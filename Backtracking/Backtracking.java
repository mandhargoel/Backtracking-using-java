package Backtracking;

public class Backtracking {

	static int count=0;
	public static void main(String[] args) {
		//QueensPermutations(new boolean[4], 0, 2, "");
		//Queencombination(new boolean[4], 0, 2, "", -1);
		//CoinChangeCombination(new int[] {2, 3,5, 6}, 10, "", 0);
		//CoinChangePermutation(new int[] {2, 3,5, 6}, 10, "");
		//QueenCombinationBoxRespect(new boolean[4], 0, 0, 2, "");
		//CoinChangeCoinRespect(new int[] {2,3,5,6}, 0, 10, "");
		//QueenCombinationBoxRespect2D(new boolean[2][2], 0, 0, 0, 2, "");
		//QueenCombinationBoxRespect2DReccall(new boolean[3][4], 0, 0, 0, 3, "");
		//QueenCombinationBoxRespect2Dkill(new boolean[3][4], 0, 0, 0, 3, "");
		//boolean[][] board = new boolean[4][4];
		//NQueen(board, 0, 0, 0, board.length, "");
		//Nknights(new boolean[4][4], 0, 0, 0, 2, "");
		//NQueen2(board, 0, 0, 4, "");
		//kQueen(board, 0, 0, 3, "");
	}
	
	public static void QueensPermutations(boolean[] boxes, int qpsf, int tq, String ans) {
		if(qpsf==tq) {
			count++;
			System.out.println(count  + ". " + ans);
			return;
		}
		for(int i=0; i< boxes.length;i++) {
			if(boxes[i]==false) {
				boxes[i]=true;
				QueensPermutations(boxes, qpsf+1, tq, ans + "q" + qpsf + "b" + i + " ");
				boxes[i]=false; //undo
			}
		}
	}
	
	public static void Queencombination(boolean[] boxes, int qpsf, int tq, String ans, int lastboxused) {
		if(qpsf==tq) {
			count++;
			System.out.println(count  + ". " + ans);
			return;
		}
		for(int i=lastboxused+1; i< boxes.length;i++) {
			
				boxes[i]=true;
				Queencombination(boxes, qpsf+1, tq, ans + "q" + qpsf + "b" + i + " ", i);
				boxes[i]=false; //undo
			
		}
	}

	public static void CoinChangeCombination(int[] denom, int amount, String ans, int lastDenomIdx) {
		if(amount==0) {
			System.out.println(ans);
			return; 
		}
		for(int i=lastDenomIdx; i<denom.length;i++) {
			if(amount>=denom[i]) {
				CoinChangeCombination(denom, amount-denom[i], ans + denom[i], i); 
			}
		}
	}
	
	public static void CoinChangePermutation(int[] denom, int amount, String ans) {
		if(amount==0) {
			count++;
			System.out.println(count + ". "+ ans);
			return; 
		}
		for(int i=0; i<denom.length;i++) {
			if(amount>=denom[i]) {
				CoinChangePermutation(denom, amount-denom[i], ans + denom[i]); 
			}
		}
	}
	
	public static void QueenCombinationBoxRespect(boolean[] board, int col,int qpsf, int tq, String ans ) {
		//positive base case
		if(qpsf ==tq) {
			System.out.println(ans);
			return;
		}
				
		//negative base case
		if(col==board.length) {
			return;
		}
		
		//place
		board[col]=true;
		QueenCombinationBoxRespect(board, col+1, qpsf+1, tq, ans + "b" + col);
		board[col]=false;
		
		//not place
		QueenCombinationBoxRespect(board, col+1, qpsf, tq, ans);
		
	}
	
	public static void CoinChangeCoinRespect(int[] denom, int vidx,int amount, String ans) {
		
		if(amount==0) {
			System.out.println(ans);
			return;
		}
		if(amount<0||vidx==denom.length) {
			return;
		}
		//yes
		CoinChangeCoinRespect(denom, vidx, amount-denom[vidx], ans + denom[vidx]);
		//no
		CoinChangeCoinRespect(denom, vidx+1, amount, ans);
	}
	
	public static void QueenCombinationBoxRespect2D(boolean[][] board, int row, int col,int qpsf, int tq, String ans ) {
		//positive base case
		if(qpsf ==tq) {
			System.out.println(ans);
			return;
		}
				
		//manually variable change
		if(col==board[0].length) {
			row++;
			col=0;
		}
				
		//negative base case
		if(row==board.length) {
			return;
		}
		
		//place
		board[row][col]=true;
		QueenCombinationBoxRespect2D(board, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col]=false;
		
		//not place
		QueenCombinationBoxRespect2D(board, row,  col+1, qpsf, tq, ans);
		
	}

	public static void QueenCombinationBoxRespect2DReccall(boolean[][] board, int row, int col,int qpsf, int tq, String ans ) {
		//positive base case
		if(qpsf ==tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
				
		//extra rec call
		if(col==board[0].length) {
			QueenCombinationBoxRespect2DReccall(board, row+1, 0, qpsf, tq, ans);
			return;
		}
				
		//negative base case
		if(row==board.length) {
			return;
		}
		
		//place
		board[row][col]=true;
		QueenCombinationBoxRespect2DReccall(board, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col]=false;
		
		//not place
		QueenCombinationBoxRespect2DReccall(board, row,  col+1, qpsf, tq, ans);
		
	}

	public static void QueenCombinationBoxRespect2Dkill(boolean[][] board, int row, int col,int qpsf, int tq, String ans ) {
		//positive base case
		if(qpsf ==tq) {
			System.out.println(ans);
			return;
		}
				
		//manually variable change
		if(col==board[0].length) {
			row++;
			col=0;
		}
				
		//negative base case
		if(row==board.length) {
			return;
		}
		
		if(IsItSafe(board, row, col)) {
			//place
			board[row][col]=true;
			QueenCombinationBoxRespect2Dkill(board, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col]=false;
		}
		//not place
		QueenCombinationBoxRespect2Dkill(board, row,  col+1, qpsf, tq, ans);
		
	}
	
	public static void NQueen(boolean [][] board, int row, int col, int qpsf, int tq, String ans) {
		
		//positive base case
		if(qpsf ==tq) {
			System.out.println(ans);
			return;
		}
		
		//manually variable change
		if(col==board[0].length) {
			row++;
			col=0;
		}
		
		//negative base case
		if(row==board.length) {
			return;
		}
		
		//place only if safe
		if(IsItSafe(board, row, col)) {
			board[row][col]=true;
			NQueen(board, row, col+1, qpsf+1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col]=false;
		}
		
		//not place
		NQueen(board, row, col+1, qpsf, tq, ans);
	}
	
	public static boolean IsItSafe(boolean[][] board, int row, int col) {
		
		//vertically upward
		int r=row-1;
		int c=col;
		while(r>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
		}
		
		//horizontally left
		r=row;
		c=col-1;
		while(c>=0) {
			if(board[r][c]) {
				return false;
			}
			c--;
		}
		
		//diagonally left
		r=row-1;
		c=col-1;
		while(r>=0&&c>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;c--;
		}
		
		//diagonally right
		r=row-1;
		c=col+1;
		while(r>=0&&c<board[0].length) {
			if(board[r][c]) {
				return false;
			}
			r--;c++;
		}
		return true;
	}

	public static void Nknights(boolean[][] board, int row,int col, int kpsf, int tk, String ans) {
		
		if(kpsf==tk) {
			System.out.println(++count + ". " + ans);
			return;
		}
		if(col==board[0].length) {
			row++;
			col=0;
		}
		if(row==board.length) {
			return;
		}
		
		if(IsItSafeKnights(board, row, col)) {
		//place
			board[row][col]=true;
			Nknights(board, row, col+1, kpsf+1, tk, ans + "{" +  row + "-" + col + "}");
			board[row][col]=false;
		}
		//not place
		Nknights(board, row, col+1, kpsf, tk, ans);
	}

	public static boolean IsItSafeKnights(boolean[][] board, int row, int col) {
		int[] rowArr= {-1,-2,-2,-1};
		int[] colArr= {2,1,-1,-2};
		for(int i=0;i<4;i++) {
			int r= row + rowArr[i];
			int c= col + colArr[i];
			
			if(r>=0 && r<board.length && c>=0 && c<board.length) {
				if(board[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void NQueen2(boolean[][] board, int row,  int qpsf, int tq, String ans) {
		if(qpsf==tq) {
			System.out.println(++count  + ". " + ans);
			return;
		}
		if(row==board.length) {
			return;
		}
		for(int col=0; col<board[0].length;col++) {
			if(IsItSafe(board, row, col)) {
				board[row][col]=true;
				NQueen2(board, row+1, qpsf+1, tq, ans  + "{" + row + "-" + col + "}");
				board[row][col]=false;
			}
		}
	}
	
	public static void kQueen(boolean[][] board, int row,  int qpsf, int tq, String ans) {
		if(qpsf==tq) {
			System.out.println(++count  + ". " + ans);
			return;
		}
		if(row==board.length) {
			return;
		}
		for(int col=0; col<board[0].length;col++) {
			if(IsItSafe(board, row, col)) {
				board[row][col]=true;
				kQueen(board, row+1, qpsf+1, tq, ans  + "{" + row + "-" + col + "}");
				board[row][col]=false;
			}
		}
		
		//not place
		kQueen(board, row+1, qpsf, tq, ans);
	}
}
