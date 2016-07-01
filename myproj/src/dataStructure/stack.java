package dataStructure;

import java.util.Scanner;


public class stack {


	public static void reverseStack(StackArray stack,StackArray newStack) throws StackEmptyException, StackFullException{

		copyToStack(stack, newStack);
		int t=0;
		while(t<5){
			stack.push(newStack.pop());	
			t++;
		}
	}

	public static void copyToStack(StackArray stack,StackArray newStack) throws StackEmptyException, StackFullException{

		if(stack.top()==1){
			newStack.push(stack.pop());
			return;
		}

		int newElement=stack.pop();
		copyToStack(stack, newStack);
		newStack.push(newElement);	

	}

	public static boolean DuplicateParen(String str){

		StackLL<Character> stack=new StackLL<>();

		for(int i=0;i<str.length();i++){

			if(str.charAt(i)=='('||str.charAt(i)=='+')
				stack.push(str.charAt(i));

			if(str.charAt(i)==')'){
				char ch=stack.pop();
				if(ch=='+'){
					while(stack.top.data=='+')
						stack.pop();
				}
				else
					return false;
				stack.pop();
			}
		}

		return true;

	}

	public static char findPair(char ch){

		if(ch=='(')
			return ')';
		else	if(ch=='{')
			return '}';
		else if(ch=='[')
			return ']';

		return '\0';

	}

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		//		StackArray stack=new StackArray();
		//		StackArray newStack=new StackArray();
		//		int n=5;
		//		while(n>0){
		//			int element=s.nextInt();
		//			stack.push(element);
		//			n--;
		//		}
		//		n=0;
		//		reverseStack(stack, newStack);
		//		
		//		while(n<5){
		//			System.out.println(stack.pop());
		//			n++;
		//		}

//		System.out.println("ENTER THE STRING:");
//		String str=s.next();
//		System.out.println(DuplicateParen(str));
		MinStack stack=new MinStack();
		
		for(int i=0;i<5;i++){
			int data=s.nextInt();
			stack.push(data);
		}
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.getMinimum());

	}

}
