package model;

/**
 * 数独ゲームの全体状態を管理するクラス。
 * <p>「正解」「問題」「現在」の3つの盤面状態を保持し、ゲームの進行に必要なデータを提供します。</p>
 */

public class GameState {
	
	/** 正解となる数字がすべて埋まった「完全盤面」 */
	private Board completeBoard;
	
	/** 完全盤面から数字を抜き、プレイヤーが解くべき状態にした「問題盤面」 */
	private Board puzzleBoard;
	
	/** プレイヤーの入力が反映される、現在進行中の「現状盤面」 */
	private Board currentBoard;
	
	/**
	 * 3種類の盤面（完全・問題・現状）をそれぞれ空の状態で初期化するコンストラクタ。
	 */
	public GameState() {
		
		currentBoard = new Board();
		completeBoard = new Board();
		puzzleBoard = new Board();
		
	}
	
	/**
	 * すべてのセルが正解で埋められた完全盤面を取得する。
	 * @return 正解データを保持する {@code Board} インスタンス
	 */
	
	public Board getCompleteBoard() {return completeBoard;}
	
	
	/**
	 * 完全盤面から一部の数字を除去した、初期の問題盤面を取得する。
	 * @return 問題データを保持する {@code Board} インスタンス
	 */

	public Board getPuzzleBoard() {return puzzleBoard;}
	
	/**
	 * プレイヤーの入力を含む、現在進行中の盤面を取得する。
	 * @return 現状の盤面データを保持する {@code Board} インスタンス
	 */
	
	public Board getCurrentBoard() {return currentBoard;}
	

	

}
