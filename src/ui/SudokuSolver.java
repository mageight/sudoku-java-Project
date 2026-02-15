package ui;

import java.util.Scanner;

import logic.CellEditor;
import model.Board;
import model.GameState;
import ui.input.AddressInputer;
import ui.input.NumberInputer;

/**
 * プレイヤーによる盤面への数字入力操作を制御するクラス。
 */

public class SudokuSolver {
	
	/**
	 * ユーザーから座標と数字の入力を受け取り、現状盤面( {@code CurrentBoard} )を更新する。
	 * 
	 * <ul>
	 *  <li>{@link AddressInputer} を介して、数独盤面上の座標（11～99）を取得する。</li>
	 *  <li>座標入力時にキャンセルコード(0)が入力された場合、入力を中断して {@code true} を返す。</li>
	 *  <li>座標確定後、{@link NumberInputer} を介して挿入する数字（1～9、または削除用の0）を取得する。</li>
	 *  <li>取得した座標と数字を {@link CellEditor#addNumber} に渡し、盤面データを更新する。</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 * @param sudoku 操作対象の盤面データを保持する {@code GameState} オブジェクト
	 * @return 操作を継続する場合は {@code true}、メニューに戻る場合は {@code false}
	 */

	public static boolean addNumber(Scanner input , GameState sudoku) {
		
		int[][] gameCurrent = sudoku.getCurrentBoard().getCellMap();
		Board puzzleBoard = sudoku.getPuzzleBoard();
		
		System.out.println("\n【数独を解く】\n");
		
		int addressInput = AddressInputer.call(input , puzzleBoard);
		if (Back.backCommand(addressInput , 0) == true) {return false;} // キャンセル判定
		
		int numberInput = NumberInputer.call(input);
		CellEditor.addNumber(gameCurrent , addressInput , numberInput);
		return true;
	}
}
