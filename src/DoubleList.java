/**
 * Class: DoubleList
 * Description: This class represents a doubly linked list of nodes of the class DoubleNode.
 * @author Jessica yang
 *
 */
public class DoubleList <T> {

	// private variables needed for DoubleList
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;

	/**
	 * Constructor initializes variables to create an empty double list.
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}

	/**
	 * This method must add a new node to the list storing newData
	 * @param index This is the index where the node will be added
	 * @param newData This is the data that will be stored in the new node
	 * @throws InvalidPositionException This is thrown when there is an invalid position given
	 */
	public void addData(int index, T newData) throws InvalidPositionException {

		// creates a new node that stores the data and will be added to the doubleList
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		
		// throws exception if the index is less than zero or index is greater than numDataItems
		if (index<0 || index>numDataItems) {
			throw new InvalidPositionException("Position is Invalid");
		}
		
		// if the index is zero (the node is added to the front)
		else if (index == 0) {
			// if the number of data items is not empty then set the new node pointing to the front and the front pointing to the new node
			if (numDataItems!=0) {
				newNode.setNext(head);
				head.setPrev(newNode);
				rear = getNode(numDataItems-1);
			}
			// set head as new node
			head = newNode;
		}
		
		// if the index is numDataItems (the node is added to the back)
		else if (index == numDataItems) {
			// if there is no rear yet, set the new node as rear, and set it pointing to last node, and set the last node pointing to rear
			if (rear == null) {
				rear = newNode;
				head.setNext(rear);
				rear.setNext(null);
				rear.setPrev(head);
			}
			// if there already is a rear, set the rear pointing to new node, the new node previous pointing to rear and set rear as new node
			else{
				rear.setNext(newNode);
				newNode.setNext(null);
				newNode.setPrev(rear);
				rear = newNode;
			}
		}
		
		// if node is added to the middle
		else {
			// get the node of the one after where it is inserted and before
			DoubleNode<T> current = getNode(index);
			DoubleNode<T> prev = getNode(index-1);
			// set the new nodes next node as the one after it and the new nodes previous node as the one before it 
			newNode.setNext(current);
			newNode.setPrev(prev);
			prev.setNext(newNode);
			current.setPrev(newNode);
		}
		
		// add one to numDataItems
		numDataItems++;
	}

	/**
	 * This method returns the node that is at the index position of the list. 
	 * @param index This is the index of what node needs to be returned
	 * @return returns the DoubleNode in DoubleList given index
	 * @throws InvalidPositionException This is thrown when there is an invalid position given
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException{
		// throws exception if the index is less than zero or index is greater or equal to numDataItems
		if (index<0 || index>=numDataItems) {
			throw new InvalidPositionException("Position is Invalid");
		}
		
		// sets count as 0 and starts from head
		int count = 0;
		DoubleNode<T> current = head;
		// goes through linked list node by node until the right index is reached
		while (count < index) {
			count ++;
			current = current.getNext();
		}
		
		// returns the node 
		return current;
	}

	/**
	 * This method removes the node that is at the index position of the list
	 * @param index This is the index where the node is being removed
	 * @throws InvalidPositionException This is thrown when there is an invalid position given
	 */
	public void removeData(int index) throws InvalidPositionException {
		// throws exception if the index is less than zero or index is greater than numDataItems
		if (index<0 || index>=numDataItems) {
			throw new InvalidPositionException("Position is Invalid");
		}
		
		// if the node being removed is at the front 
		if (index == 0) {
			// change head to the next node
			head = head.getNext();
			// if there is more than one node then set the new head pointing to previous as null
			if (numDataItems != 1) {
				head.setPrev(null);
			}
		}
		
		// if node being removed is at the end of the list
		else if (index == numDataItems-1) {
			// set rear to the one before rear and set the new rear pointing to null
			rear = rear.getPrev();
			rear.setNext(null);
		}
		
		// if node being removed is in the middle of the list
		else {
			// take the node after the current node and the one before the current node
			DoubleNode<T> next = getNode(index+1);
			DoubleNode<T> prev = getNode(index-1);
			// set the next node pointing to the previous node and previous node pointing to the next
			next.setPrev(prev);
			prev.setNext(next);

		}
		// remove 1 from numDataItems
		numDataItems--;
	}

	/**
	 * This method returns the data stored in the node located at the index position of the list 
	 * @param index This is the index of the data needed to be returned
	 * @return Returns data item of a given index
	 * @throws InvalidPositionException This is thrown when there is an invalid position given
	 */
	public T getData(int index) throws InvalidPositionException {
		// throws exception if the index is less than zero or index is greater than numDataItems

		if (index<0 || index>=numDataItems) {
			throw new InvalidPositionException("Position is Invalid");
		}
		return getNode(index).getData();
	}

	/**
	 * This method stores newData at the node in position index of the list
	 * @param index This is the index of the node which the data will be changed
	 * @param newData This is the new data that will replace data
	 * @throws InvalidPositionException. This is thrown when there is an invalid position given
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		// throws exception if the index is less than zero or index is greater than numDataItems
		if (index<0 || index>=numDataItems) {
			throw new InvalidPositionException("Position is Invalid");
		}
		getNode(index).setData(newData);
	}

	
}
