package logic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数独のアルゴリズムで使用する、ランダムに並び替えられた重複のない数字リストを生成するクラス。
 */

public class RandomArrayGenerator {
	
	/**
	 * 1から9の数字をランダムな順序で保持するリストを生成するメソッド 
	 * 
	 * @return 1～9の数字がシャッフルされた {@code ArrayList<Integer>}
	 */

	public static ArrayList<Integer> createRandomNumber() {
		
		var numbers = new ArrayList<Integer>();
		for (int i = 1 ; i <= 9 ; i++ ) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers;

	}
	
	/**
	 * 11から99 (※10の倍数を除く) の数字をランダムな順序で保持するリストを生成するメソッド
	 * <ul>
	 *  <li>数独の盤面をランダムな順序で走査（穴あけ等）する際に使用します。</li>
	 *  <li>10の倍数（列インデックスが0に相当するもの）は除外されます。</li>
	 * </ul>
	 *  @return シャッフルされた座標リスト（例：[23, 81, 11, ...]）
	 */
	
	public static ArrayList<Integer> createRandomAddress(){
		
		var randomAddress = new ArrayList<Integer>();
		for (int ten = 1 ; ten <= 9 ; ten++ ) {
			for (int one = 1 ; one <= 9 ; one++ ) {
				randomAddress.add((ten * 10) + one);
			}	
		}
		Collections.shuffle(randomAddress);
		return randomAddress;
		
	}
}	

