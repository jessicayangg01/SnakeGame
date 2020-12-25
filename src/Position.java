/**
 * 
 * Class: Position
 * Description: An object of class Position represents the position of a square of the grid. 
 * @author Jessica Yang
 * 
 */


public class Position {
	// private variables needed for position
	private int positionRow;
	private int positionCol;
	
	/**
	 * Constructor method initializes rows and columns of a new position
	 * @param row This is the row of the position
	 * @param col This is the column of the position
	 */
	public Position(int row, int col) {
		positionRow = row;
		positionCol = col;
		
	}
	
	/**
	 * This method returns row of the position
	 * @return position row
	 */
	public int getRow() {
		return positionRow;
	}
	
	/**
	 * This method returns column
	 * @return position column
	 */
	public int getCol() {
		return positionCol;
	}
	
	/**
	 * This method changes row to given new row 
	 * @param newRow This is the new integer that will be set to row 
	 */
	public void setRow(int newRow) {
		positionRow = newRow;
	}
	
	/**
	 * This method changes column to given new column
	 * @param newCol This is the new integer that will be set to column
	 */
	public void setCol(int newCol) {
		positionCol = newCol;
	}
	
	/**
	 * This method checks if two positions are equal in terms of rows and columns 
	 * @param otherPosition This is the other position that you are comparing your position to
	 * @return A boolean true or false whether the two positions equal or do not equal
	 */
	public boolean equals(Position otherPosition) {
		if (positionRow == otherPosition.getRow() && positionCol == otherPosition.getCol()) {
			return true;
		}
		else return false;
	}
}
