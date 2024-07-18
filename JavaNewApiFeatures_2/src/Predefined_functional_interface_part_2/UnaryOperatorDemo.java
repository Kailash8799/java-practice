package Predefined_functional_interface_part_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// UnaryOperator
		// T apply(T t)
		UnaryOperator<Integer> fun=x->x+1;
		
		int n=fun.apply(10);
		System.out.println(n);
		
		List<String> l=new ArrayList<String>();
		l.add("java");
		l.add("c");
		//replaceall method take direct argument as one unary operator
		System.out.println(l);
		l.replaceAll(ele->ele+" language");
		System.out.println("after replacing");
		System.out.println(l);
	}

}
