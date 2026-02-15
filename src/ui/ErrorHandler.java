package ui;

import model.Board;

/**
 * ユーザーからの入力値が有効であるかを検証し、エラー時に通知を行う機能を提供するクラス。
 * <p>範囲外の数値や、数独のルール上書き換え不可能なセルへのアクセスをブロックする。</p>
 */

public class ErrorHandler {
	
	/**
	 * 入力された数値が指定された範囲内 {@code [min - max]} であるか検証する。
	 * 
	 * <ul>
	 *  <li>範囲外の場合、エラーメッセージを表示して {@code false} を返す。</li>
	 *  <li>メニュー選択の番号チェックなどに使用する。</li>
	 * </ul>
	 * 
	 * @param input 検証対象の数値
	 * @param min 許容される最小値
	 * @param max 許容される最大値
	 * @return 範囲内であれば {@code true}、範囲外であれば {@code false}
	 */

	public static boolean checkInt(int input , int min , int max) {
		if (input > max || input < min) {
			System.out.println("\n" + input + "は不正な値です！[" + min +  "-" + max + "]の間で数値を入力してください！\n");
			return false;
		}
		return true;
	}
	
	/**
	 * 入力された2桁の座標番号が、数独盤面の有効な範囲内（各桁1～9）であるか検証する。
	 * 
	 * <ul>
	 *  <li>10の位（行）または1の位（列）に0が含まれる、あるいは範囲外の場合にエラーとなる</li>
	 *  <li>例: 10, 20, 01, 100 などの不正入力を排除する</li>
	 * </ul>
	 * 
	 * * @param addressNumber 2桁の座標番号
	 * @return 有効な座標であれば {@code true}、無効であれば {@code false}
	 */
	
	public static boolean checkAddress(int addressNumber) {
		
		int row = addressNumber / 10 ; 
		int col = addressNumber % 10 ;
		
		if ( row > 9 || row < 1 || col > 9 || col < 1 ) {
			System.out.println("\n[" + row + "," + col + "]は不正な座標です！有効な値を入力してください！\n");
			return false;
		}
		return true;
	}
	
	/**
	 * 指定された座標が「問題として最初から埋まっているセル」でないか検証する。
	 * 
	 * <ul>
	 *  <li>{@code puzzleBoard} の該当セルが 0 でない場合、そのセルは固定数字と判断し、編集を拒否する。</li>
	 *  <li>内部で配列のインデックス調整（入力値 - 1）を行って判定します。</li>
	 * </ul>
	 * 
	 * @param addressNumber 2桁の座標番号
	 * @param puzzleBoard 問題データ（固定数字の判定基準）を持つ {@code Board} インスタンス
	 * @return 編集可能な空白セルであれば {@code true}、固定数字セルであれば {@code false}
	 */
	
	public static boolean isEditableCell(int addressNumber , Board puzzleBoard ) {
		
		int row = addressNumber / 10 ; 
		int col = addressNumber % 10 ;
		
		if ( puzzleBoard.getCellMap()[row -1 ][col - 1 ] != 0 ) {// 座標をインデックス番号化するため -1 する
			System.out.println("\n座標[" + row + "," + col + "]の数値は固定です！空白セルの座標を入力してください！\n");
			return false;
		}
		return true;
	}
}
