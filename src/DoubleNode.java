/**
 * Class: DoubleNode
 * Description: This class represents the nodes in a doubly linked list.
 * @author Jessica yang
 *
 */
public class DoubleNode<T> {

	// private variables needed for Double Node
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;

	/**
	 * Constructor initializes variables to an empty double node
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}

	/**
	 * Constructor initializes variables to a double node containing given data
	 * @param newData This is the data that will be stored int the node
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}

	/**
	 * The method getNext will return the next node 
	 * @return next
	 */
	public DoubleNode<T> getNext(){
		return next;
	}

	/**
	 * The method getPrev will return the previous node
	 * @return prev
	 */
	public DoubleNode<T> getPrev(){
		return prev;
	}

	/**
	 * The method getData will return the data stored within the node
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * The method setNext will change the next node that it points to
	 * @param nextNode This is the next node that will be set as next
	 */
	public void setNext(DoubleNode <T> nextNode) {
		next = nextNode;
	}

	/**
	 * The method setPrev will change the previous node that it points to
	 * @param prevNode This is the previous node that will be set as prev
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}

	/**
	 * The method setData will change the data stored within the node
	 * @param newData This is the new data that will be stored in data
	 */
	public void setData(T newData) {
		data = newData;
	}
}
