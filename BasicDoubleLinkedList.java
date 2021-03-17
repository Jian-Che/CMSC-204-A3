import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	  protected Node head;
	  protected Node tail;
	  protected int size;

	  public BasicDoubleLinkedList() {
	    this.head = null;
	    this.tail = null;
	    this.size = 0;
	  }


	  public BasicDoubleLinkedList<T> addToEnd(T data) {
	   

	    if (head == null) {
	      head = new Node(data);
	      tail = head;
	    } else {
          Node newNode = new Node(data);
	      tail.next = newNode;
	      newNode.previous = tail;
	      tail = newNode;
	    }
	    size++;
	    return this;
	  }


	  public BasicDoubleLinkedList<T> addToFront(T data) {

	    if (head == null) {
	      head = new Node(data);
	      tail = head;
	    } else {
	      Node newNode = new Node(data);
	      head.previous = newNode;
	      newNode.next = head;
	      head = newNode;
	    }
	    size++;
	    return this;
	  }


	  public T getFirst() {
	    return head.data;
	  }


	  public T getLast() {
	    return tail.data;
	  }


	  public int getSize() {
	    return size;
	  }


	  public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
	    return new NodeIterator();
	  }


	  public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
	    Node node = head;
	    while (node != null) {
	      if (comparator.compare(targetData, node.data) == 0) {
	        if (node == head) {
	          head = head.next;
	        } else if (node == tail) {
	          tail = tail.previous;
	        } else {
	          node.previous.next = node.next;
	        }

	      }
	      node = node.next;
	    }
	    size--;
	    return this;
	  }

	
	  public T retrieveFirstElement() {

	    if (head != null) {
	      Node firstE = head;
	      head = head.next;
	      size--;
	      return firstE.data;	      
	    }
	   
	    return null;
	  }

	
	  public T retrieveLastElement() {
	    if (tail != null) {
	    	Node lastE = tail;
	    	tail = tail.next;
	    	size--;
	    	return lastE.data;	    	
	    }
		return null;

	  }

	
	  public ArrayList<T> toArrayList() {
	    ArrayList<T> list = new ArrayList<>();
	    Node first = head;

	    while (first != null) {
	      list.add(first.data);
	      first = first.next;
	    }
	    return list;
	  }


	  public class Node {
	    protected Node previous;
	    protected Node next;
	    protected T data;

	    public Node(T data) {
	      this.previous = null;
	      this.next = null;
	      this.data = data;
	    }
	    
	    public Node(Node previous, T data, Node next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
	  }


	  public class NodeIterator implements ListIterator<T> {

	    protected Node current = head;
	    protected Node last;

	    @Override
	    public boolean hasNext() {
	      return current != null;
	    }

	    @Override
	    public boolean hasPrevious() {
	      return last != null;
	    }

	    @Override
	    public T next() throws NoSuchElementException {
	      if (hasNext()) {
	        last = current;
	        current = current.next;
	        return last.data;
	      }
	      throw new NoSuchElementException("No next elements available in List");
	    }

	    @Override
	    public T previous() throws NoSuchElementException {
	      if (hasPrevious()) {
	        current = last;
	        last = last.previous;
	        return current.data;
	      }
	      throw new NoSuchElementException("No previous elements available in List");
	    }

	    @Override
	    public int nextIndex() throws UnsupportedOperationException {
	      throw new UnsupportedOperationException();
	    }

	    @Override
	    public int previousIndex() throws UnsupportedOperationException {
	      throw new UnsupportedOperationException();
	    }

	    @Override
	    public void remove() throws UnsupportedOperationException {
	      throw new UnsupportedOperationException();
	    }

	    @Override
	    public void set(T data) throws UnsupportedOperationException {
	      throw new UnsupportedOperationException();
	    }

	    @Override
	    public void add(T data) throws UnsupportedOperationException {
	      throw new UnsupportedOperationException();
	    }

	  }

	}
