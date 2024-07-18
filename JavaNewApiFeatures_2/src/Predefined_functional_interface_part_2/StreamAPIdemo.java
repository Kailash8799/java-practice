package Predefined_functional_interface_part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPIdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Stream does not store elements. 
//		It simply conveys elements from a source such as a data structure,through a pipeline of computational operations.
//      Stream is functional in nature. Operations performed on a stream does not modify it's source. 
		List<Integer> l = Arrays.asList(1, 10, 25, 3, 65, 75, 85, 150, 170);
		
		Stream<Integer> data = l.stream().sorted();
		data.forEach(n -> System.out.println(n));

		System.out.println();
		l.stream().filter(n -> n % 2 != 0)// predicate will be passed as an argument
				.sorted()
				.map(n -> n * 2)
				.forEach(n -> System.out.println(n));

		System.out.println();
		int r = l.stream()
				.filter(n -> n % 2 != 0)// predicate will be passed as an argument
				.sorted()
				.map(n -> n * 2)
				.reduce(0, (c, e) -> c + e);

		System.out.println("r=" + r);
		
		List<String> colours = new ArrayList<>();
		colours.add("red");
		colours.add("green");
		colours.add("green");
		colours.add("blue");
		// display unique elements in upper-case
		System.out.println();
		System.out.println(1);
		colours.stream().distinct().map(c -> c.toUpperCase()).forEach(System.out::print);
		
		// display unique elements in upper-case
		System.out.println();
		System.out.println(2);
		colours.stream().distinct().map(String::toUpperCase).forEach(System.out::print);
		
		System.out.println();
		List<String> uniqueColours = colours.stream().distinct().map(String::toUpperCase).toList();
		System.out.println();
		System.out.println(uniqueColours);
	}

}
