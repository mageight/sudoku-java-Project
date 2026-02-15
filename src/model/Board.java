package model;

/**
 * 数独の9×9盤面データを保持し、盤面操作の基本機能を提供するモデルクラス。
 */

public class Board {
	
	/** 盤面の数字を保持する2次元配列 (0は空白、1～9が数値) */
	private int[][] cellMap;
	
	/**
     * 9×9の空の盤面を初期化するコンストラクタ。
     */
	
	public Board() {cellMap = new int[9][9];} 
	
	/**
     * 盤面を構成する9×9の数字配列を取得する。
     * 
     * @return 現在の盤面状態を示す2次元配列
     */
	
	public int[][] getCellMap() {return this.cellMap;}
	
	/**
     * 引数として渡された盤面インスタンス( {@code base} )から、現在の盤面へ内容を複製（ディープコピー）する。
     * <ul>
     *  <li>元の盤面データの参照を切り離し、値のみを全セル分コピーする</li>
     *  <li>コピー先の盤面を操作しても、コピー元の盤面には影響を及ぼさない</li>
     * </ul>
     * @param base 複製元となる {@code Board} インスタンス
     */
	
	public void copyBoard(Board base) {
		
		int[][] printBoard = base.getCellMap();
		for (int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				cellMap[i][j] = printBoard[i][j];  
			}
		}
	}
}
