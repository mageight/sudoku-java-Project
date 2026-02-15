package ui.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Board;
import ui.ErrorHandler;
import ui.SudokuView;

/**
 * ユーザーから盤面上の座標入力を受け取り、バリデーションを行うクラス。
 */

public class AddressInputer {
	
	/**
	 * ユーザーに対して座標入力を促し、有効な座標（11～99）またはキャンセルコード（0）を返す。
	 * 
	 * <ul>
	 *  <li>数値以外の入力があった場合は例外（{@link InputMismatchException}）をキャッチし、再入力を促す</li>
	 *  <li>入力された数値が有効な座標形式（各桁1～9）であるかを {@link ErrorHandler#checkAddress} で検証</li>
	 *  <li>その座標がパズル盤面で埋まっている固定セルでないかを {@link ErrorHandler#isEditableCell} で検証</li>
	 *  <li>固定セルが指定された場合、ヒントとしてパズル盤面を再表示</li>
	 *  <li>キャンセルコード {@code 0} が入力された場合は、即座に呼び出し元へ制御を戻す</li>
	 * </ul>
	 * 
	 * @param input 標準入力（Scannerインスタンス）
	 * @param puzzleBoard 編集可否を判定するための初期パズル盤面
	 * @return 有効な座標数値、またはキャンセルを示す 0
	 */
	
	public static int call(Scanner input , Board puzzleBoard) {
		
		while(true) {
			System.out.println("数字を入力する空白マスの座標を\n[横：10の桁 縦：1の桁]の2桁の数字で入力してください");
			System.out.println("【コマンドメニューに戻る場合は[0]を入力してください】");
			System.out.println("例（最も左上の座標は[11]）");
			System.out.print("＞");
			try {
				int addressInput = input.nextInt();
				if (addressInput == 0) {return addressInput;}// キャンセルコードの即時返却
				
				// バリデーション1：座標としての妥当性チェック
				boolean isValidNumber = ErrorHandler.checkAddress(addressInput);
				if (isValidNumber == true) {
					
					// バリデーション2：編集可能なセル（空白）かどうかのチェック
					boolean isEditable = ErrorHandler.isEditableCell(addressInput, puzzleBoard);
					if(isEditable == true) {
						System.out.println("[" + addressInput + "]");
						return addressInput;
					}
					
					System.out.println("【初期盤面】"); // 固定セルだった場合は、注意喚起のために初期盤面を表示
					SudokuView.output(puzzleBoard);
				}
			}catch(InputMismatchException e){
				
				input.nextLine();
				System.out.println("\n不正な値が入力されました！");
				System.out.println("有効な値を半角数字で入力してください\n");
			}
		}
	}
}
