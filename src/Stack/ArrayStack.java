package Stack;

public class ArrayStack implements Stack{

	public static final int CAPACITY = 1024;
	public Object S[];
	public int t = -1;
	public int N;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		N = capacity;
		S = new Object[N];
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t<0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (t+1);
	}

	@Override
	public Object top() throws StackEmptyException{
		// TODO Auto-generated method stub
		if(isEmpty()) throw new StackEmptyException("Stack is Empty");
		return S[t];
	}

	@Override
	public void push(Object o) throws StackFullException{
		// TODO Auto-generated method stub
		if(size()==N) throw new StackFullException("Stack is Full");
		S[++t] = o;
		
	}

	@Override
	public Object pop() throws StackEmptyException{
		// TODO Auto-generated method stub
		if(isEmpty()) throw new StackEmptyException("Stack is Empty");
		Object element = S[t];
		S[t--] = null;
		return element;
	}
	
	public void print() throws StackEmptyException{
		if(isEmpty()) throw new StackEmptyException("Stack is empty");
		int ptr = t;
		while(ptr>=0) {
			System.out.println(S[ptr--]);
		}
	}

}
