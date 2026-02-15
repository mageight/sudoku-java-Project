package logic;

import model.GameState;

/**
 * 数独の盤面に対して、指定の調査を行い真偽型を返す機能を提供するクラス。
 * 
 */

public class CellChecker {
	
	/**
	 * セル座標と9×9盤面配列を受け取り、数独基本ルールに従って
	 * 対象セルに挿入する数字が有効か調べるメソッド
	 * 
	 * <ul>
	 *  <li>列・行・3×3ブロック間に存在する数字と挿入する数字で重複がないか比較する</li>
	 *  <li>数字の重複が見つかった場合は {@code false} を返す</li>
	 * </ul>
	 * 
	 * @param row 対象セルの行インデックス (0～8)
	 * @param col 対象セルの列インデックス (0～8)
	 * @param number セルに追加する数字
	 * @param cellMap 対象数独盤面 (9×9の数字配列、0は空白として扱う)
	 * @return 挿入数字が数独基本ルールに従っていれば{@code true}、反していた場合{@code false}
	 */

	public static boolean isValidNumber(int row , int col , int number , int[][] cellMap) {
		
		//行チェック
		for (int r = 0 ; r < 9 ; r++ ) {
			if (cellMap[row][r] == number) {return false;}
		}	
		
		//列チェック
		for (int c = 0 ; c < 9 ; c++ ) {
				if(cellMap[c][col] == number) {return false;}
		}	
		
		//3×3ブロックチェック
		int rBlockBase = (row/3) * 3;
		int cBlockBase = (col/3) * 3;
		
		for (int rowBlock = 0 ; rowBlock < 3 ; rowBlock++) {
			for (int colBlock = 0 ; colBlock < 3 ; colBlock++ ) {
					if(cellMap[rBlockBase + rowBlock][cBlockBase + colBlock] == number) {return false;}
			}
		}
		return true;			
	}
	
	/**
	 * ゲーム状態({@code GameState sudoku} )の現状盤面( {@code CurrentBoard} )と完全盤面({@code CompleteBoard} )を比較し
	 * すべてのセルが一致しているか調査する
	 * 
	 * <ul>
	 *  <li>現状盤面と完全盤面のすべてのセルで数字を比較し一致していることを確認する</li>
	 *  <li>数字の相違が見つかった場合は {@code false} を返す</li>
	 * </ul>
	 * 
	 * @param sudoku 盤面データを含むゲーム状態オブジェクト
	 * @return すべての数字が一致していれば {@code true}、反していた場合 {@code false}
	 */
	
	 public static boolean isMatching (GameState sudoku) {
			
		int[][] answer = sudoku.getCurrentBoard().getCellMap();
		int[][] correct = sudoku.getCompleteBoard().getCellMap();
			
		for (int i = 0 ; i < 9 ; i++ ) {
			for (int j = 0 ; j < 9 ; j++ ) {
				if (answer [i][j] != correct [i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
