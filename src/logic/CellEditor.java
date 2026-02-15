package logic;

import model.Cell;

/**
 * 数独盤面上のセルに数字を挿入する機能を提供するクラス。
 */

public class CellEditor {
	
	/**
	 * 9×9盤面配列の指定座標に数字を挿入するメソッド。
	 * 
	 * <ul>
	 *  <li>2桁の座標番号( {@code address} )を座標( {@code int[2]} )に変換する</li>
	 *  <li>座標のセルに数字を挿入する</li>
	 * </ul>
	 * 
	 * @param cellMap 対象数独盤面 (9×9の数字配列、0は空白として扱う)
	 * @param address 盤面上の座標を示す2桁の数字 (10の位が行、1の位が列 [例：11なら1行目1列目］10の倍数は入力不可) 
	 * @param number 挿入する数字 (0～9)
	 */
	
	public static void addNumber(int[][] cellMap, int address , int number) {
		
		int[] addCell = Cell.addressing(address);
		int addRow = addCell[0];
		int addCol = addCell[1];
		
		cellMap[addRow - 1][addCol - 1] = number; //座標をインデックス番号化するため -1 する
		
	}

}

