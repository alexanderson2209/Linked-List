/*
 * Author: Alexander Anderson
 * Summer 2014
 */
package linkedList;

/*
 * Linked List 
 */
public class LinkedList <E> {

	private Node<E> head;
	private int size;
	
	/*
	 * Gets data at specified index. Throws IndexOutOfBoundsException if index > size
	 */
	public E get(int index) {
		Node<E> tempNode = head;
		
		int indexTracker = 0;
		if (index > size)
			throw new IndexOutOfBoundsException();

		//step through linked list looking for index.
		while (indexTracker < size) {
			if (indexTracker == index)
				break;
			tempNode = tempNode.next;
			indexTracker++;
		}
		return tempNode.data;
	}

	/*
	 * Appends data to the end of the linked list.
	 */
	public void append(E data) {
		if (head == null) {
			head = new Node<E>(data, null);
		}
		else {
			Node<E> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = new Node<E>(data, null);
		}
		size++;
	}

	/*
	 * Returns the size of the linked list.
	 */	
	public int getSize() {
		return size;
	}

	/*
	 * Clears all Nodes in the linked list
	 */	
	public void clear() {
		head = null;
		size = 0;
	}

	/*
	 * Insert newElement before key. Throws RuntimeException if key is not in linked list.
	 */	
	public void insertBefore(E key, E newElement) {
		Node<E> tempNode1 = head;
		boolean runtimeExceptionControl = true;
		
		if (tempNode1.data.equals(key)) {
			head = new Node<E>(newElement, head);
			runtimeExceptionControl = false;
			size++;
		}
		
		//step through linked list looking for key.
		while (tempNode1.next != null) {
			if (tempNode1.next.data.equals(key)) {
				tempNode1.next = new Node<E>(newElement, tempNode1.next);
				runtimeExceptionControl = false;
				size++;
				break;
			}
			else
				tempNode1 = tempNode1.next;
		}
		
		//Last node in linked list, if this Node's data doesnt equal key, then we throw RuntimeException
		if (tempNode1.data.equals(key)) {
			tempNode1 = new Node<E>(newElement, tempNode1);
		}
		else if (runtimeExceptionControl)
			throw new RuntimeException();
	}

	/*
	 * Insert newElement after key. Throws RuntimeException if key is not in linked list.
	 */	
	public void insertAfter(E key, E newElement) {
		Node<E> tempNode = head;

		//step through linked list looking for key.
		while (tempNode.next != null) {
			if (tempNode.data.equals(key)) {
				tempNode.next = new Node<E>(newElement, tempNode.next);
				size++;
				break;
			}
			else {
				tempNode = tempNode.next;
			}
		}
		
		//Last node in linked list, if this Node's data doesnt equal key, then we throw RuntimeException
		if (tempNode.data.equals(key)) {
			tempNode.next = new Node<E>(newElement, tempNode.next);
			size++;
		}
		else
			throw new RuntimeException();
	}

	/*
	 * Removes key from linked list. If key is not in the linked list, throw RuntimeException.
	 */	
	public void remove(E key) { 
		Node<E> tempNode = head;
		boolean didRemove = false;
		if (tempNode.data.equals(key)) {
			head = tempNode.next;
			size--;
			didRemove = true;
		}
		
		while (tempNode.next != null) {
			if (tempNode.next.data.equals(key)) {
				tempNode.next = tempNode.next.next;
				size--;
				didRemove = true;
				break;
			}
			else {
				tempNode = tempNode.next;
			}
		}
		if (!didRemove)
			throw new RuntimeException();
	}

	/*
	 * Returns string representation of the linked list.
	 *
	 * Example: [a, b, c, d, e, f, g]
	 */	
	public String toString() {
		if (head == null) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node<E> tempNode = head;
		while(tempNode.next != null) {
			sb.append(tempNode.data);
			sb.append(", ");
			tempNode = tempNode.next;
		}
		sb.append(tempNode.data);
		sb.append("]");
		return sb.toString();
	}

	/*
	 * Node class. Used to store data, and the next node in the linked list.
	 */
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}		
	}
}

