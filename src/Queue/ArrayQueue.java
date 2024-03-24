package Queue;

public class ArrayQueue implements Queue {

	private static final int CAPACITY = 1024;
	private int front=0,rear=0,N;
	private Object Q[];
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public ArrayQueue(int cap) {
		N = cap;
		Q = new Object[cap];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return (N-front+rear)%N;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (front==rear);
	}

	@Override
	public void Enqueue(Object o) throws QueueFullException{
		// TODO Auto-generated method stub
		if(size()==N-1) throw new QueueFullException("Queue is Full");
		
		Q[rear] = o;
		rear = (rear+1)%N;
		
	}

	@Override
	public Object Dequeue() throws QueueEmptyException {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new QueueEmptyException("Queue is Empty");
		Object o = Q[front];
		Q[front] = null;
		
		front = (front+1)%N;
		
		return o;
	}

	@Override
	public Object front() throws QueueEmptyException {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new QueueEmptyException("Queue is Empty");
		return Q[front];
	}
	
	public void print() throws QueueEmptyException{
		if(isEmpty()) throw new QueueEmptyException("Queue is Empty");
		if(front<=rear) {
			for(int i = front;i<rear;i++) {
				System.out.println(Q[i]);
			}
		}
		else {
			int i = front;
			while(i<N) {
				System.out.println(Q[i++]);
			}
			i = 0;
			while(i<rear) {
				System.out.println(Q[i++]);
			}
		}
	}

}
