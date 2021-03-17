import java.util.Comparator;
import java.util.ListIterator;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T> {

  private Comparator<T> comparator;

 
  public SortedDoubleLinkedList(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  
  public SortedDoubleLinkedList<T> add(T data) {
    Node testNode = new Node(data);
    Node nNode = head;
 
    if (size == 0) {
      head = testNode;
      tail = head;

    } else if (comparator.compare(head.data, data) > 0) {
      testNode.next = head;
      head.previous = testNode;
      head = testNode;

    } else {

      while (comparator.compare(nNode.data, data) < 0) {

        if (nNode.next == null) {
          nNode.next = testNode;
          testNode.previous = nNode;
          tail = testNode;
          size++;
          return this;
        } else {
          nNode = nNode.next;
        } 
        
        nNode.next = testNode;
        testNode.previous = nNode.previous;
        nNode.previous = testNode;
        testNode.next = nNode;

      }
     
  
     
    }
    
    size++;
    return this;
  }

 
  @Override
  public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
    return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
  }

 
  @Override
  public ListIterator<T> iterator() {
    return super.iterator();
  }


  @Override
  public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Invalid operation for sorted list");
  }


  @Override
  public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Invalid operation for sorted list");

  }

}
