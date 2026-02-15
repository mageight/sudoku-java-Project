package ui;

import model.Board;

/**
 * 数独の盤面をコンソール上に視覚的に表示するためのクラス。
 */

public class SudokuView {
	
	/**
	 * 指定された {@link Board} の内容を、数独特有の枠組みを伴う形式で出力する。
	 * 
	 * <ul>
	 *  <li>上部には列番号（1-9）、左側には行番号（1-9）を表示し、座標を指定を簡便化する。</li>
	 *  <li>3x3のブロックごとに罫線（| や -）を引き、視認性を向上。</li>
	 *  <li>値が 0 のセルは空白として表示し、1-9 の数字のみを出力する。</li>
	 * </ul>
	 * 
	 * @param suboku 表示対象となる {@code Board} インスタンス
	 */

	public static void output(Board suboku){
		
		int[][] targetMap = suboku.getCellMap();
		
		String header =    " | 1 2 3 | 4 5 6 | 7 8 9 |";
		String separator = "-+-------+-------+-------+";
		
		System.out.println(header);
		System.out.println(separator);
			
	    for (int row = 1 ; row <= 9 ; row++) { 
	        System.out.print(row + "| ");
	        	
	        for (int col = 1 ; col <= 9 ; col++ ) { 
	        	
	        	if(targetMap[row-1][col-1] != 0) {
	        		System.out.print(targetMap [row-1][col-1] + " "); // 0（未入力）は空白、それ以外は数字を表示
	        	}else {
	        		System.out.print("  ");
	        	}	
	            if ( col % 3 == 0) {System.out.print("| ");} // 3列ごとに縦の区切り線を挿入
	        }
	        
        	System.out.println();
        	if ( row % 3 == 0 ) {
        		System.out.println(separator); // 3行ごとに横の区切り線を挿入
        	}
	    }
	}
}
