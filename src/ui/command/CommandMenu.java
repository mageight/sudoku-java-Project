package ui.command;

import java.util.Scanner;

/**
 * ゲームのメインメニューを表示し、ユーザーの行動を選択させるコマンドクラス。
 */

import ui.input.SelectInputer;

public class CommandMenu {
	
	/**
	 * メニュー画面を表示し、実行するアクション番号を取得する。
	 * 
	 * <ul>
	 *  <li>「1:数独を解く」：ゲーム本編（数字入力モード）への遷移を想定</li>
	 *  <li>「2:答え合わせ」：現状盤面と完全盤面の照合処理への遷移を想定</li>
	 *  <li>数値のバリデーションは {@link SelectInputer} によって行われ、1または2のみが返ります</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 * @return ユーザーが選択したコマンド番号 (1 または 2)
	 */

	public static int call(Scanner input) {

		String message = """
				\n【メニューコマンド】
				コマンドを数字で選んでください(半角数字)
				＞1:数独を解く
				＞2:答え合わせ（すべてのマスを埋めてください
				＞""";
		int selectNumber = SelectInputer.call(input, message, 1, 2);// 1～2の範囲外が入力された場合は、SelectInputer内でループし再入力が促される
		return selectNumber;
	}
}
