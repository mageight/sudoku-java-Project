package app;

import java.util.Scanner;

import model.GameState;
import ui.SudokuAnswer;
import ui.SudokuSolver;
import ui.SudokuView;
import ui.command.CommandContinue;
import ui.command.CommandMenu;

public class Play {
	
	/**
	 * 数独プレイシステムへのエントリーポイント
	 * <p>
	 * 【コマンドメニュー】から【数独を解く】と【答え合わせ】モードを呼び出す役割を持つ
	 * </p>
	 *
	 * <p>
	 * 本クラスは数独プレイに置ける、UI 層の起点として機能し、実際のロジック処理は
	 * Logic パッケージ内のクラスへ委譲する。
	 * </p>
	 * @param input 標準入力（Scannerインスタンス）
	 * @param sudoku ゲーム状態（盤面情報や解答情報を保持）
	 */

	public static void playGame(Scanner input , GameState sudoku){
			
		System.out.println("\nそれでは数独スタート！");
			
		sudoku.getCurrentBoard().copyBoard(sudoku.getPuzzleBoard());
		
		while(true) {
			
			int command = CommandMenu.call(input);
			
			switch (command) {
				case 1 -> {
					while (true) {
						SudokuView.output(sudoku.getCurrentBoard());
						boolean back = SudokuSolver.addNumber(input , sudoku);
						if (back == false) {break;}
					}
				}case 2 -> {					
					SudokuAnswer.judgeAnswer(sudoku);
					CommandContinue.call(input);
					return;
				}
			}
		}
	}
}
