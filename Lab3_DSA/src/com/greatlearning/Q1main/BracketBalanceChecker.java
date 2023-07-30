package com.greatlearning.Q1main;
import java.util.Scanner;
public class BracketBalanceChecker {

	static int top=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] array= new char[10];
		System.out.println("Enter any expression with brackets \"()\" :");
		
		String str= sc.nextLine();
		for (int i = 0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if(ch=='('|| ch==')')
			push(array,ch);
			
			for(int j=top; j>0; j--)
			{
				if(array[j-1]=='(' && array[j]==')')
					pop(2);
			}
		}
		

		

		
		if(top==-1)
			System.out.println("\nIts a Balance brackets expression : "+top);
		else
			System.out.println("\nIts not a Balance brackets expression : "+top);
	}
	
	public static void push(char[] array,char ch)
	{
		top= top +1;
		array[top]=ch;
	}
	
	public static void pop(int i)
	{
		if(top==-1)
			System.out.println("No Items left to POP from the stack");
		else
			top=top-i;
		
	}

}
