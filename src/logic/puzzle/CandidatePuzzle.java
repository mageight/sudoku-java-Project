package logic.puzzle;

import logic.UniquenessChecker;
import model.Board;
import model.GameState;

/**
 * CandidatePuzzle アルゴリズムを用いてパズル盤面を生成するクラス
 *
 * <p>
 * CandidatePuzzle アルゴリズムは、候補削除方式の考え方を応用した
 * 独自のパズル生成手法であり、完全盤面から候補が一意となるマスを
 * ランダムに空白化することで問題盤面を作成する。
 * </p>
 */

public class CandidatePuzzle {
	
	/**
	 * CandidatePuzzle アルゴリズムを実行し、一意の解が保証された問題盤面を生成する
	 * 
	 * <ul>
	 *  <li>正解データである {@code CompleteBoard} の破損を防ぐため、作業用の {@code Board} インスタンス内で加工を行う</li>
	 *  <li>{@link PuzzlerAlgorithm#candidatePuzzling} による空白化と、{@link UniquenessChecker#check} による検証を繰り返す</li>
	 *  <li>解答パターンが正確に1通り（{@code count == 1}）になるまで試行を継続し、品質を確保する</li>
	 *  <li>最終的に完成した一意解パズルを {@link GameState} の {@code PuzzleBoard} に反映する</li>
	 * </ul>
	 * 
	 * @param sudoku ゲーム状態（盤面情報や解答情報を保持するコンテナ）
	 */


	public static void puzzling(GameState sudoku) {
		
		Board clipBoard = new Board(); //CompleteBoard保護のため作業用Boardクラスを生成
		Board completeBoard = sudoku.getCompleteBoard();
		
		int count = 0; //一意性確認用カウント、事前生成
		
		do {
			
			clipBoard.copyBoard(PuzzlerAlgorithm.candidatePuzzling(completeBoard)); //パズル化作業用ボードにディープコピーする
		
			count = UniquenessChecker.check(clipBoard, 0);
		
		}while( count != 1); //解答が1つだった場合にループ解除
		
		sudoku.getPuzzleBoard().copyBoard(clipBoard);
		
	}	
}
