package logic.puzzle;

import java.util.Scanner;

import model.GameState;
import ui.SudokuView;
import ui.command.CommandPuzzle;

/**
 * ユーザーの選択に応じたアルゴリズムで数独の問題盤面を生成・管理するクラス。
 */

public class PuzzleBoard {
	
	/** RandomPuzzle アルゴリズムにおいて生成される空白マスの最小値。 */
	private static final int MIN_EMPTY_CELLS = 20;
	
	/**
	 * ユーザーが選択したアルゴリズムに基づいて数独パズル盤面を生成する。
	 * 
	 * <ul>
	 *  <li>{@link CommandPuzzle} を介して生成アルゴリズムの選択入力を受け取る</li>
	 *  <li>「標準生成」では、論理的に解ける一意解パズル（{@link CandidatePuzzle}）を生成</li>
	 *  <li>「ランダム生成」では、規定の範囲内でランダムな数の空白を持つパズル（{@link RandomPuzzle}）を生成</li>
	 *  <li>生成完了後、{@link SudokuView#output} を用いて盤面をコンソールに表示</li>
	 *  <li>生成されたデータは {@code sudoku} オブジェクト内の {@code PuzzleBoard} に上書きされる</li>
	 * </ul>
	 * 
	 * @param input ユーザー入力を受け取る Scanner
	 * @param sudoku ゲーム状態（盤面情報や解答情報を保持）
	 */
	
	public static void create(Scanner input , GameState sudoku) {
		
		int select = CommandPuzzle.call(input);
		
		switch (select){
		
		case 1 ->{
			CandidatePuzzle.puzzling(sudoku); // 論理的な一意解パズル生成
		}
		case 2 ->{
			int emptyCount = new java.util.Random().nextInt(33) + MIN_EMPTY_CELLS;
			System.out.println("空白マス数：" + emptyCount);
			RandomPuzzle.puzzling(sudoku, emptyCount); // 指定範囲（20〜52マス）でランダムな空白数を決定
		}
		}
		System.out.println("\n\n");
		SudokuView.output(sudoku.getPuzzleBoard());
		System.out.println("数独盤面の生成が完了いたしました。\n");
	}
}
