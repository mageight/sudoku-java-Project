package logic;

import model.Board;
import model.GameState;

/**
 * 完全盤面インスタンスの空白セルをすべて埋め、パズルの「正解」を生成するクラス。
 * <p>
 * 現在は標準的な 9x9 盤面に対応していますが、将来的な 16x16 盤面の実装や
 * 異なる生成アルゴリズムの導入を見越し、拡張性を持たせるため独立したクラスとして定義しています。
 * </p>
 */

public class CompleteBoardCreator {
	
	/**
	 * ゲーム状態オブジェクトを受け取り、その中の完全盤面を完成させます。
     *  <p>
     * 内部で {@link BoardFiller#fill(Board)} を呼び出し、バックトラッキングアルゴリズムを用いて
     * 全てのセルに矛盾なく数字を配置します。
     * </p> 
	 * 
	 * @param sudoku 盤面データを含むゲーム状態オブジェクト
	 */

	public static void create(GameState sudoku) {
		
		Board completeBoard = sudoku.getCompleteBoard();
		BoardFiller.fill(completeBoard);
		
	}
}
