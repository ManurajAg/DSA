package runningPack;

import Queue.ArrayQueue;
import Queue.QueueEmptyException;
import Queue.QueueFullException;

public class QueueMain {
	public static void main(String[] args){
		ArrayQueue q = new ArrayQueue(6);
		try {
			q.Enqueue(1);
			q.Enqueue(2);
			q.Enqueue(3);
			q.Enqueue(4);
			q.Enqueue(5);
			System.out.println("Queue :- ");
			q.print();
			
			System.out.println("Dequeued Element :- "+q.Dequeue());
			System.out.println("Dequeued Element :- "+q.Dequeue());
			System.out.println("Dequeued Element :- "+q.Dequeue());
			
			q.Enqueue(6);
			q.Enqueue(7);
			System.out.println("Queue After dequeue and enqueue :- ");
			q.print();
			//System.out.println(q.size());
			//System.out.println(q.front());
		}
		catch(QueueFullException e) {
			System.out.println("Queue is Full");
		} catch (QueueEmptyException e) {
			System.out.println("Queue is Empty");
		}
		
	}
}
