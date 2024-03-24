package Queue;

public interface Queue {
	
	public int size();
	public boolean isEmpty();
	public void Enqueue(Object o);
	public Object Dequeue() throws QueueEmptyException;
	public Object front() throws QueueEmptyException;
	
}
