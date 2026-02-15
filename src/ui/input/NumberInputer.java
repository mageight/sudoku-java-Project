package ui.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import ui.ErrorHandler;

/**
 * ユーザーから盤面に配置する数字の入力を受け取り、バリデーションを行うクラス。
 */

public class NumberInputer {
	
	/**
	 * ユーザーに対して数字入力を促し、有効な値（0～9）を返す。
	 * 
	 * <ul>
	 *  <li>数値以外の入力があった場合は例外（{@link InputMismatchException}）をキャッチし、再入力を促す</li>
	 *  <li>入力された数値が有効な範囲（0～9）内であるかを {@link ErrorHandler#checkInt} で検証</li>
	 *  <li>値 {@code 0} は、盤面の数字を削除（空白に戻す）するための特別な入力として定義</li>
	 *  <li>バリデーションを通過した値は、最終確認としてコンソールに表示された後、呼び出し元へ返す</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 * @return 確定した入力数字 (0～9)
	 */
	
	public static int call(Scanner input) {
		
		while(true) {
			System.out.println("入力する数字を[1-9]で入力してください");
			System.out.print("入力した数字を削除する場合は[0]を入力してください\n＞");
			
			try {
				int numberInput = input.nextInt();
				boolean check = ErrorHandler.checkInt(numberInput , 0, 9);
				
				if (check == true) {
					System.out.println("[" + numberInput + "]");
					return numberInput;
				}	
			}catch(InputMismatchException e){
				
					input.nextLine();
					System.out.println("\n不正な値が入力されました！");
					System.out.println("有効な値を半角数字で入力してください\n");
			}
		}
	}
}
