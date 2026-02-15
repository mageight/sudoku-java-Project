package logic.puzzle;

import logic.UniquenessChecker;
import model.Board;
import model.GameState;

/**
 * RandomPuzzle アルゴリズムを用いてパズル盤面を生成するクラス
 *
 * <p>
 * RandomPuzzle アルゴリズムは、完全盤面からランダムに指定数のマスを空白化し、
 * その結果が一意解となるまで生成と一意性チェックを繰り返す独自のパズル生成手法である。
 * </p>
 * 
 */

public class RandomPuzzle {

	/**
	 * RandomPuzzle アルゴリズムを用いてパズル化盤面を生成する。
	 * 
	 * <ul>
	 *  <li>CompleteBoard 保護のため、パズル化は別の作業用のボードにて行う</li>
	 *  <li>解答の一意になるまで、パズル化と一意性チェックを繰り返す</li>
	 *  <li>生成された盤面を GameState の PuzzleBoard に上書きする</li>
	 * </ul>
	 * 
	 * @param sudoku ゲーム状態（盤面情報や解答情報を保持）
	 * @param emptyCount 空白マス生成数（ループ打ち切り用）
	 */
	
	public static void puzzling(GameState sudoku , int emptyCount) {
		
		Board clipBoard = new Board();
		Board completeBoard = sudoku.getCompleteBoard();
		
		int count = 0; //一意性確認用カウント、事前生成
		
		do {
			count = 0 ;
			
			clipBoard.copyBoard(PuzzlerAlgorithm.randomPuzzling(completeBoard , emptyCount));
		
			count = UniquenessChecker.check(clipBoard, 0);
		
		}while( count != 1);
		
		sudoku.getPuzzleBoard().copyBoard(clipBoard);
		
	}	
}
