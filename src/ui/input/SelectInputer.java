package ui.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import ui.ErrorHandler;

/**
 * 数値選択入力を一括して管理する共通入力クラス。
 * <p>任意のメッセージを表示し、指定された範囲内の数値が入力されるまで再入力を促す</p>
 */

public class SelectInputer {
	
	/**
	 * ユーザーに対して選択を促すメッセージを表示し、バリデーション済みの数値を返す。
	 * 
	 * <ul>
	 *  <li>数値以外の入力（文字など）があった場合は {@link InputMismatchException} をキャッチし、エラー通知後に再入力を促す</li>
	 *  <li>入力された数値が指定された最小値 {@code min} から最大値 {@code max} の範囲内であるかを {@link ErrorHandler#checkInt} で検証</li>
	 *  <li>このメソッドを使用することで、呼び出し側のクラス（Commandクラス群など）から例外処理や範囲判定の記述を排除し、コードの重複を防ぐ</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 * @param message ユーザーに提示する選択メニュー等のメッセージ
	 * @param min 許容される最小値
	 * @param max 許容される最大値
	 * @return バリデーションを通過した選択番号
	 */

	public static int call(Scanner input , String message , int min , int max) {
		
		while(true){			
			System.out.print(message);
			try {
				int selectNumber = input.nextInt();
				boolean isCheck = ErrorHandler.checkInt(selectNumber, min, max); // 共通エラーハンドラーによる範囲チェック
				if(isCheck == true) {
					return selectNumber;
				}
			}catch(InputMismatchException e){
				input.nextLine();
				System.out.println("\n不正な値が入力されました！");
				System.out.println("半角数字[" + min + "-" + max +  "]の範囲で入力してください\n");
			}
		}
	}	
}
