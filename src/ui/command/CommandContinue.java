package ui.command;

import java.util.Scanner;

/**
 * ゲーム終了または継続の選択を制御するコマンドクラス。
 */

import ui.input.SelectInputer;

public class CommandContinue {
	
	/**
	 * ユーザーに対してゲームの継続確認メッセージを表示し、入力を受け取る。
	 * 
	 * <ul>
	 *  <li>「YES」が選択された場合、メソッドを終了（return）し、メインループの次の周回へ戻る。</li>
	 *  <li>「NO」が選択された場合、プログラム全体を即座に終了する。</li>
	 *  <li>入力のバリデーション（1または2の制限）は {@link SelectInputer} によって行われる。</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 */
	
	public static void call(Scanner input) {

		String message = """
				数独を続けますか？
				＞1 YES（新しいパズルを生成）
				＞2 NO （終了）
				＞""";
		int selectNumber = SelectInputer.call(input, message, 1, 2);// 指定範囲(1～2)以外の入力は SelectInputer 側で弾かれる
		if(selectNumber == 2) {System.out.println("数独を終了します。");System.exit(0);}
		return;
	}
}
