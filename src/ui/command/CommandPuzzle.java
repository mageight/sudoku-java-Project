package ui.command;

import java.util.Scanner;

/**
 * 数独パズルの空白マス生成アルゴリズムを選択させるコマンドクラス。
 */

import ui.input.SelectInputer;

public class CommandPuzzle {

	/**
	 * 空白マスの生成方式を選択するメニューを表示し、ユーザーの選択に応じた番号を返す。
	 * 
	 * <ul>
	 *  <li>「1:標準生成」：論理的に解きやすい、バランスの取れた空白配置アルゴリズムを想定</li>
	 *  <li>「2:ランダム生成」：運要素の強い、ランダムな空白配置アルゴリズムを想定</li>
	 *  <li>選択結果はコンソールに表示され、バリデーションは {@link SelectInputer} で行われます</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 * @return 選択されたアルゴリズム番号 (1 または 2)
	 */
	
	public static int call(Scanner input) {

		String message = """ 
				空白マス生成アルゴリズムを選択してください。
				(半角数字[1-2]で入力)
				
				＞1:標準生成
					(標準的アルゴリズムを用いて、空白マスを生成します。程よい難易度です。)
				
				＞2:ランダム生成
					(ランダムなマスを空白にします。普通の数独に飽きて運試しがしたい人はこちら。）				
				
				＞""";
		int selectNumber = SelectInputer.call(input, message, 1, 2);
		
		switch (selectNumber) {
		case 1 -> System.out.println("標準生成で、空白マスを生成します");
		case 2 -> System.out.println("ランダム生成で、空白マスを生成します");
		}
		
		return selectNumber;
	}
}
