package Predefined_functional_interface_part_2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BinaryOperator take two argument of same type and return same type as operands
				//BinaryOperator<T>
				BinaryOperator<Integer> fun=(x1,x2)->x1+x2;
				int ans=fun.apply(10, 20);
				System.out.println(ans);
			//BiFunction interface is inherited into Binary operator
				//BiFunction<T,T,T>
				BiFunction<Integer,Integer,Integer> fun1=(x1,x2)->x1+x2;
				
				ans=fun1.apply(10, 20);
				System.out.println(ans);
	}

}
