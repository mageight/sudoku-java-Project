package ui;

/**
 * 各種入力シーンにおいて、前の画面に戻る、またはキャンセルするための判定機能を提供するクラス。
 */

public class Back {
	
	/**
	 * 入力された値がキャンセルコード（戻るための数値）に該当するかを判定します。
	 * 
	 * <ul>
	 * 	<li>現在は単一の数値による比較ですが、将来的に異なるキャンセルコードの採用や
	 *  複数のコードによる判定が必要になった際の拡張性を考慮し、独立したメソッドとして実装</li>
	 * 	<li>判定結果を真偽値で返すことで、呼び出し側の条件分岐を簡略化する</li>
	 * </ul>
	 * 
	 * @param value ユーザーから入力された数値
	 * @param cancelCode 該当シーンで「戻る」として定義されている数値
	 * @return 入力値がキャンセルコードと一致すれば {@code true}、そうでなければ {@code false}
	 */

	public static boolean backCommand(int value , int cancelCode) {
		if(value == cancelCode) {return true;}
		return false;
	}
}
