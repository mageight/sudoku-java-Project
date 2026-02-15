package logic;

import model.Board;

/**
 * 生成されたパズル盤面の解答が一意的（唯一無二）であることを調査する機能を提供するクラス。
 */

public class UniquenessChecker {
	
	/**
	 * 空白セルを持つ数独盤面の解答パターン数をバックトラッキングを用いて調査するメソッド。
	 * 
	 * <ul>
	 *  <li>盤面上の空白セルを{@link BoardScanner#checkEmptyCell(int[][])}で走査する<br>
	 *      → 空白セルがない場合は解答数( {@code count} )を+1して返す<br>
	 *      → 空白セルがある場合、1から9の数字を順に仮置きし、ルールに適合すれば再帰的に次のセルを調査</li>
	 *  <li>解答数が2つに達した時点で、それ以上の探索を打ち切り、即座に呼び出し元へ戻る</li>
	 *  <li>全ての候補を試しても解答が見つからない場合、セルの状態を戻して（バックトラック）前の探索に戻る</li>
	 * </ul>
	 * 
	 * @param puzzle 調査対象の空白セルを持つ数独盤面（ディープコピーによって保護）
	 * @param count 現状までに発見された解答数カウント（通常は0から開始）
	 * @return 発見された解答の総数（ただし、効率化のため最大値は2）
	 */

	public static int check(Board puzzle,int count) {
		
		Board checkBoard = new Board();
		checkBoard.copyBoard(puzzle); //PuzzleBoard保護のため、確認作業用Board生成
		int[][] checkMap = checkBoard.getCellMap();
			
		int[] blankCell = BoardScanner.checkEmptyCell(checkMap);
		if (blankCell == null) {
			
			count += 1;return count; //空白セルがない＝解答なので、countを+1してreturn

		}else {	
			int bRow = blankCell[0];
			int bCol = blankCell[1];
					
			for (int i = 1; i <= 9 ; i++) {
					
				boolean noConflict = CellChecker.isValidNumber(bRow, bCol, i, checkMap);
				if (noConflict == true) {
					checkMap [bRow][bCol] = i;
						
					count = check(checkBoard,count); //再帰呼び出し
					if (count > 1) { return count;} //解答が2つ見つかった時点でバックトラッキングを打ち切りreturnを返し続ける
				}
			}	
			checkMap [bRow][bCol] = 0;
			return count;
		}
	}
}
