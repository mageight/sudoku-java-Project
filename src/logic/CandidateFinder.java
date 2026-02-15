package logic;

import java.util.HashSet;

/**
 * 数独盤面の指定セルに対して、数独ルールに従って候補となる数字集合を抽出する機能を提供するクラス
 * 
 */

public class CandidateFinder {
	
	/**
	 * セル座標と9×9盤面配列を受け取り、数独基本ルールに従って
	 * 対象セルに入る可能性のある数字集合を返すメソッド
	 * 
	 * <ul>
	 *  <li>列・行・3×3ブロック間に存在する数字を、候補数字から取り除く</li>
	 *  <li>対象セルに既に数字が入力されている場合、その数字も候補から外されることに注意</li>
	 * </ul>
	 * 
	 * @param row 対象セルの行インデックス (0～8)
	 * @param col 対象セルの列インデックス (0～8)
	 * @param cellMap 対象数独盤面 (9×9の数字配列、0は空白として扱う)
	 * @return 候補として残った数字集合（{@code HashSet<Integer>}）
	 */

	public static HashSet<Integer> getCandidate(int row , int col , int[][] cellMap){
		
		var candidate = new HashSet<Integer>();
		for (int n = 1 ; n <= 9 ; n++) {candidate.add(n);}
		
		for (int r = 0 ; r < 9 ; r++ ) {
				candidate.remove(cellMap[r][col]);
		}	
		for (int c = 0 ; c < 9 ; c++ ) {
				candidate.remove(cellMap[row][c]);
		}
		int rSpace = (row/3) * 3;
		int cSpace = (col/3) * 3;
				
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++ ) {
					candidate.remove(cellMap[rSpace + i][cSpace + j]);
			}
		}
		return candidate;
		
	}
}
