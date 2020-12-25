/**
 * Class: BoardGameLinked
 * Description: This class represents the board game where the snake moves around eating apples.
 * @author Jessica yang
 *
 */
public class BoardGameLinked {

	// private variables needed for BoardGameLinked
	private int boardLength;
	private int boardWidth;
	private SnakeLinked theSnake;
	private DoubleList<String> board[];

	@SuppressWarnings("unchecked")
	/**
	 * Constructor method implements board game variables 
	 * @param boardFile This is the string that contains the file name that needs to be open
	 */
	public BoardGameLinked(String boardFile) {
		// reads file and stores it in variable file
		MyFileReader file = new MyFileReader(boardFile);
		// does not take into account the first two numbers
		file.readInt();
		file.readInt();
		// sets the next two numbers as board length and width
		boardLength = file.readInt();
		boardWidth = file.readInt();
		// the next two snake positions 
		theSnake = new SnakeLinked (file.readInt(), file.readInt());

		// initializes double list matrix with matrix length as boardWidth and doubleList nodes as boardLength and adds empty to each spot
		board = new DoubleList[boardWidth];
		for (int i = 0; i<boardWidth; i++) {
			board[i] = new DoubleList<String>();
			for (int j = 0 ; j< boardLength; j++) {
				board[i].addData(j, "empty");
			}
		}
		// reads through the end of the file adds the positions and strings in those positions into array of doubleLists
		while (!file.endOfFile()) {
			board[file.readInt()].setData(file.readInt(), file.readString());
		}
		
	}

	/**
	 * This method returns the object in given row and column
	 * @param row This is the row of the position 
	 * @param col This is the column of the position
	 * @return This returns the object in the position given
	 * @throws InvalidPositionException This is thrown when the position given is invalid
	 */
	public String getObject (int row, int col) throws InvalidPositionException { 
		// InvalidPositionException must be thrown if row or col are negative, if row greater or equal to boardWidth, or if col greater or equal to boardLength.
		if( row<0 || col<0 || row >= boardWidth || col>= boardLength) {
			throw new InvalidPositionException("Position is out of bounds.");
		}
		return board[row].getData(col);
	}

	/**
	 * This method changes the object in given row and column
	 * @param row This is the row of the given position
	 * @param col This is the column of the given position
	 * @param newObject This is the new object being set 
	 */
	public void setObject(int row, int col, String newObject) {
		board[row].setData(col, newObject);
	}

	/**
	 * This method returns theSnake
	 * @return theSnake
	 */
	public SnakeLinked getSnakeLinked() {
		return theSnake;
	}

	/**
	 * This method  stores the value of newSnake in instance variable theSnake
	 * @param newSnake This is the new snake that will be stored as theSnake
	 */
	public void setSnakeLinked(SnakeLinked newSnake) {
		theSnake = newSnake;
	}

	/**
	 * This method returns the board length
	 * @return boardLength
	 */
	public int getLength() {

		return boardLength;
	}

	/**
	 * This method returns the board width
	 * @return boardWidth
	 */
	public int getWidth() {

		return boardWidth;
	}

}
