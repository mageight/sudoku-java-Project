package app;

import java.util.Scanner;

import logic.CompleteBoardCreator;
import logic.puzzle.PuzzleBoard;
import model.GameState;

/**
 * 数独の自動生成およびプレイシステム
 * 
 * @author D.Hamaguchi
 * @version 1.8
 * @since 2026/02/06
 */

public class Main {
	
	/**
	 * 数独アプリケーションのエントリーポイント。
	 * <p>
	 * アプリ起動後、タイトル画面を表示し、ゲーム状態を初期化する。
	 * 完全盤面、パズル化盤面を生成しプレイモードに移行する。
	 * また、コンテニュー時も本メソッドから再開される。
	 * </p>
	 *
	 * <p>
	 * 本クラスは UI 層の起点として機能し、実際のロジック処理は
	 * Logic パッケージ内のクラスへ委譲する。
	 * </p>
	 * 
	 * @param args コマンドライン引数（未使用）
	 */

	public static void main(String[] args) {
		
		Scanner input = new java.util.Scanner(System.in);
		
		while(true) { //コンティニュー用のループ処理
		
			System.out.print("\n数独へようこそ\n\n");
		
			GameState sudoku = new GameState();
		
			CompleteBoardCreator.create(sudoku); 
		
			PuzzleBoard.create(input , sudoku);
			
			Play.playGame(input , sudoku);
			
		}
	}	
}
