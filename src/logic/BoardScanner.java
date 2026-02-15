package logic;

/**
 * 盤面に特定条件のセルが存在するかチェックする機能を提供するクラス
 * 
 */

public class BoardScanner {
	
	/**
	 * 盤面に空白セルが存在するかチェックし、最初に見つかった空白セルの座標を返すメソッド
	 * 
	 * @param cellMap チェックの対象となる 9×9 の盤面配列
	 * @return 空白マスがあると座標を保持したint[]配列を、空白セルがない場合はnullを返す
	 */
	
	public static int[] checkEmptyCell(int[][] cellMap) {
	    for (int r = 0; r < 9; r++) {
	        for (int c = 0; c < 9; c++) {
	            if (cellMap[r][c] == 0) return new int[]{r, c};
	        }
	    }
	    return null; 
	}
}
