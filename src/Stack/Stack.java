package Stack;

public interface Stack {

	public boolean isEmpty();
	public int size();
	public Object top() throws StackEmptyException;
	public void push(Object o);
	public Object pop() throws StackEmptyException;
	
	
}
