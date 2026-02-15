package logic.puzzle;

import logic.CandidateFinder;
import logic.RandomArrayGenerator;
import model.Board;
import model.Cell;

/**
 * 数独パズルの生成アルゴリズムを提供するユーティリティクラス。
 *
* <p>
 * 完全盤面（CompleteBoard）を基に、難易度や生成方式の異なる2種類の空白化アルゴリズムを実装
 * いずれのメソッドも元の盤面データを破壊せず、新しい {@link Board} インスタンスを返却する
 * </p>
 *
 * <ul>
 *   <li>{@code randomPuzzling} : 指定された個数のマスをランダムに空白化する方式</li>
 *   <li>{@code candidatePuzzling} : 候補が一意となるマスのみを空白化する方式</li>
 * </ul>
 */


public class PuzzlerAlgorithm {
	
	/**
	 * 完全盤面から、指定された個数のマスをランダムに空白化する。
	 * <ul>
	 *  <li>内部で {@link RandomArrayGenerator#createRandomAddress()} を使用し、全座標をシャッフルしたリストを取得</li>
	 *  <li>リストの先頭から順に、指定された {@code emptyCount} に達するまでセルを 0 (空白) に書き換える</li>
	 *  <li>解答の一意性は保証されませんが、パズルとしての自由度が高い盤面を生成</li>
	 * </ul>
	 *
	 * @param completeBoard 完全盤面（9x9 の数独解答）
	 * @param emptyCount 空白にするマスの目標数
	 * @return パズル化された新しい {@code Board} インスタンス
	 */

	public static Board randomPuzzling(Board completeBoard , int emptyCount) {
		
		Board emptyBoard = new Board();
		emptyBoard.copyBoard(completeBoard);
		int[][] emptyCell = emptyBoard.getCellMap();
		
		var randomAddressList = RandomArrayGenerator.createRandomAddress();
		
		int count = 0;
				
		for(Integer randomAddressNumber : randomAddressList) {
			int[] randomAddress = Cell.addressing(randomAddressNumber);
			
			int ranRow = randomAddress[0] - 1;
			int ranCol = randomAddress[1] - 1;
			
			emptyCell[ranRow][ranCol] = 0;
			count += 1;
			
			if(count >= emptyCount) {return emptyBoard;} // 目標の空白数に達した時点で生成終了
		}
		return emptyBoard;
	}
	
	/**
	 * 完全盤面から、「候補が一意となるマス（論理的に特定可能なマス）」のみを空白化する。
	 * 
	 * <ul>
	 *  <li>全座標をランダムな順序で走査し、各マスの周囲（行・列・ブロック）の状況を確認</li>
	 *  <li>{@link CandidateFinder#getCandidate} により、そのマスの候補数字が1つ（元の数字のみ）である場合、空白化の対象とする</li>
	 *  <li>一意に解答可能な構造を維持しやすいため、論理パズルとしての質が高い盤面を生成</li>
	 * </ul>
	 *
	 * @param completeBoard 完全盤面（9x9 の数独解答）
	 * @return 候補削除法に基づくパズル化が施された新しい {@code Board} インスタンス
	 */
	
	public static Board candidatePuzzling(Board completeBoard) {
		
		Board emptyBoard = new Board();
		emptyBoard.copyBoard(completeBoard);
		int[][] emptyCell = emptyBoard.getCellMap();
		
		var randomAddressList = RandomArrayGenerator.createRandomAddress();
		
		for(Integer randomAddressNumber : randomAddressList) {
			int[] randomAddress = Cell.addressing(randomAddressNumber);
			
			int ranRow = randomAddress[0] - 1;
			int ranCol = randomAddress[1] - 1;
			
			// 周囲の状況から「候補がそれしかない」マスを特定
			// ※CandidateFinder.getCandidate().size() == 0 は「他に候補がない（確定）」という判定ロジック
			if(CandidateFinder.getCandidate(ranRow , ranCol , emptyCell).size() == 0) {
				emptyCell[ranRow][ranCol] = 0;
			}
		}
		return emptyBoard;
	}
}
