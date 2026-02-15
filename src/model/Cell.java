package model;

/**
 * 数独盤面上のセル座標に関する計算や、属性管理を行うクラス。
 * 
 * <p>
 * 現在は主に2桁の座標番号を行列インデックスに変換する機能を提供します。
 * 将来的にはセルの属性（固定数字フラグや候補数字リストなど）を保持する拡張を想定しています。
 * </p>
 */

public class Cell {
	
	//拡張用パラメータ
	//private int[] address; 
	//private boolean puzzleFlag;
	//private Set<Integer> candidate;
	
	/**
	 * 2桁の座標番号( {@code addressNumber} )を、行・列の各成分に分解し配列として返す。
	 * 
	 * <ul>
	 *  <li>10の位を 行(row)、1の位を 列(col)として抽出します</li>
	 *  <li>戻り値の配列は {@code int[0]} が行、{@code int[1]} が列を示します</li>
	 *  <li>例: {@code 23} を入力した場合、{@code {2, 3}} が返されます</li>
	 * </ul>
	 * 
	 * @param addressNumber 2桁の座標番号 (例: 11～99)
	 * @return 行と列のインデックスを格納した {@code int} 型配列
	 */

	public static int[] addressing(int addressNumber) {
		
		int row = addressNumber / 10;
		int col = addressNumber % 10;
		
		int[] address = new int[] {row,col};
		
		return address;
	}
}
