package ui;

import logic.CellChecker;
import model.GameState;

/**
 * プレイヤーが完成させた盤面の正誤判定を行い、結果を表示する機能を提供するクラス。
 */

public class SudokuAnswer {
	
	/**
	 * プレイヤーの最終的な解答と正解盤面を照合し、結果をコンソールに出力する。
	 * 
	 * <ul>
	 *  <li>{@link CellChecker#isMatching(GameState)} を使用して、現状盤面と完全盤面を比較する。</li>
	 *  <li>「プレイヤーの解答」と「正解（答え）」の両方を {@link SudokuView#output} で並べて表示する。</li>
	 *  <li>判定結果に基づき、正解なら祝福メッセージを、不正解ならその旨を表示する。</li>
	 * </ul>
	 * 
	 * @param sudoku 判定対象となる「現状盤面」および「完全盤面」を保持する {@code GameState} オブジェクト
	 */

	public static void judgeAnswer(GameState sudoku) {
		
		System.out.println("【解答】");
		boolean check = CellChecker.isMatching(sudoku); // 内部で2つの盤面を突き合わせる
	
		System.out.println("あなたの解答");
		SudokuView.output(sudoku.getCurrentBoard());
		System.out.println("答え");
		SudokuView.output(sudoku.getCompleteBoard());
	
		if (check == true) {System.out.println("おめでとうございます！正解です！");}
		else {System.out.println("残念！不正解です");}
	}
	
}
