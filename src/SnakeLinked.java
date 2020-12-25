/**
 * 
 * Class: SnakeLinked
 * Description: The class stores the information about the snake as it moves around the board.
 * @author Jessica Yang
 * 
 */

public class SnakeLinked {

	// private variables needed for Snake Linked
	private int snakeLength;
	private DoubleList<Position> snakeBody;

	/**
	 * Constructor initializes the snake length and snake body, as well as adds the position head to snake body
	 * @param row This is the row of the head position
	 * @param col This is the column of the head position
	 */
	public SnakeLinked(int row, int col) {
		snakeLength = 1;
		snakeBody = new DoubleList<Position>();
		Position head = new Position(row, col);
		snakeBody.addData(0, head);

	}

	/**
	 * The method getLength returns the length of the snake
	 * @return This method returns integer snakeLength
	 */
	public int getLength() {
		return snakeLength;

	}

	/**
	 * The method Position returns the Position object stored in the node of the doubly linked list with the given index. 
	 * @param index This is the index of the position needed 
	 * @return Position of the index
	 */
	public Position getPosition(int index) {
		// if the index is not in bounds, then return null
		if (index<0 || index>= snakeLength) {
			return null;
		}
		return snakeBody.getData(index);
	}

	/**
	 * The method snakePosition returns true if pos is in the doubly linked list of snakeBody, and it returns false otherwise. 
	 * @param pos This is the given position used to compare 
	 * @return boolean variable true if pos is in doubly linked list and false if it is not.
	 */
	public boolean snakePosition(Position pos) {
		boolean inSnake = false;
		// goes through each data in snake body to check if position exists within it
		for (int i = 0; i <snakeLength; i++) {
			if (snakeBody.getData(i).equals(pos)) {
				inSnake = true;
			}
		}
		return inSnake;
	}

	/**
	 * The method Position changes the position of the snake head to a specified direction
	 * @param direction The direction given to determine where the new snake head will be 
	 * @return the new position of snake head 
	 */
	public Position newHeadPosition(String direction) {
		// creates a new position for the new head of the snake 
		Position newhead = new Position(snakeBody.getData(0).getRow(),snakeBody.getData(0).getCol());
		// changes the direction of the new snake head according to what direction was given
		if (direction.equals("up")) {
			newhead.setRow(snakeBody.getData(0).getRow()-1);
		}
		else if (direction.equals("down")) {
			newhead.setRow(snakeBody.getData(0).getRow()+1);
		}
		else if (direction.equals("right")) {
			newhead.setCol(snakeBody.getData(0).getCol()+1);
		}
		else if (direction.equals("left")) {
			newhead.setCol(snakeBody.getData(0).getCol()-1);
		}
		return newhead;
	}

	/**
	 * The method moveSnakeLinked moves all of the positions of the snake in the snakeBody linked list down one position to move the snake body
	 * @param direction This is the given direction that will determine which direction the snake will move
	 */
	public void moveSnakeLinked(String direction){
		// starting from the end of the snakeBody, set each position to the position one before it
		for (int i = snakeLength-1; i>0 ; i--) {
			snakeBody.setData(i, snakeBody.getData(i-1)); 
		}
		// changes the head position 
		snakeBody.setData(0, newHeadPosition(direction));
	}

	/**
	 * The method shrink decreases the value of snakeLength by 1 and deletes the last node in the doubly linked list of snakeBody.
	 */
	public void shrink() {
		snakeBody.removeData(snakeLength-1);
		snakeLength --;
	}

	/**
	 * The method grow increases the length of the snake by 1 and moves the snake’s head in the direction specified.
	 * @param direction This is the given direction that will determine which direction the snake will move.
	 */
	public void grow(String direction) {
		// adds a new node at the end of snakeBody to increase the snakes length
		snakeBody.addData(snakeLength, snakeBody.getData(snakeLength-1));
		// increases snakeLength variable and moves snake
		moveSnakeLinked(direction);
		snakeLength++;		
	}

}
