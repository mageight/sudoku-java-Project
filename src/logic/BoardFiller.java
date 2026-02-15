package logic;

import java.util.ArrayList;

import model.Board;

/**
 * 盤面上の空白マスを数独ルールに従って埋めるための機能を提供するクラス
 * 
 * 空の Board を完全盤面にしたり、途中状態の数独盤面を完成させることができる
 */

public class BoardFiller {
	
	/**
	 * 未完成な盤面をバックトラッキング法を用いて全ての空白セルを埋めるメソッド。
	 * 
	 * <ul>
	 * <li>盤面上の空白セルを{@link BoardScanner#checkEmptyCell(int[][])}で特定する<br>
	 * 　　→空白セルがない場合は探索を終了しtrueを返してメソッド終了</li>
	 * <li>{@link RandomArrayGenerator} により、1から9の数字をランダムな順序で試行する</li>
	 * <li>各セルで数独のルール（行・列・3x3ブロック内の重複）を {@link CellChecker} で検証する</li>
	 * <li>全ての候補を試した場合は、一つ前のセルに戻って別の数字を試行（バックトラッキング）します。</li>
	 * </ul>
	 * 
	 * @param sudoku 完全盤面化の対象となる{@code Board}オブジェクト（内部の配列データが直接更新されます）
	 * @return 盤面が完全に埋まった場合は {@code true}、埋められない場合は {@code false}
	 */

	public static boolean fill(Board sudoku) {
		
		int[][] cellMap = sudoku.getCellMap();
		
		int[] blankCell = BoardScanner.checkEmptyCell(cellMap); 
		if (blankCell == null) {
			return true;} //cellMapに空白セルがない場合trueを返して処理終了

		else {	

			int bRow = blankCell[0];
			int bCol = blankCell[1];
			
			ArrayList<Integer> randomNumberArray = RandomArrayGenerator.createRandomNumber();
				
			for (int i = 0; i < 9 ; i++) {
				int randomNumber = randomNumberArray.get(i);
				
				boolean noConflict = CellChecker.isValidNumber(bRow, bCol, randomNumber, cellMap); //重複ルールに則っているか検査
				if (noConflict == true) {					
					cellMap [bRow][bCol] = randomNumber; //抽出した空セルにrandomNumberに代入
					
					boolean fullBoardFlag = fill(sudoku); //重複ない場合boardFillerを再帰呼び出し
					if (fullBoardFlag == true) { // 空白セルをすべて埋めたらtrueを保持し続け、再帰を抜け続ける
						return true; //
					}
				}
			}
			cellMap [bRow][bCol] = 0; //1～9に適合数字がなかった場合、対象セルに0を代入してバックトラッキング
			return false;
		}
	}
}
