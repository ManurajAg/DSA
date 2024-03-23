package runningPack;

import Stack.ArrayStack;
import Stack.StackEmptyException;
import Stack.StackFullException;

public class Main {

	public static void main(String[] args) {
		ArrayStack s = new ArrayStack();
		try {
			s.push(10);
			s.push(20);
			s.push(30);
			s.push(40);
			System.out.println(s.top());
			s.print();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.print();
		}
		catch(StackFullException e) {
			System.out.println("Stack is Full");
		}
		catch(StackEmptyException e) {
			System.out.println("Stack is empty");
		}
	}
}
