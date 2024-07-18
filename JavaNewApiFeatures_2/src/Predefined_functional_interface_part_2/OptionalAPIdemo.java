package Predefined_functional_interface_part_2;

import java.util.Optional;

public class OptionalAPIdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="DDU";
		System.out.println(s.toUpperCase());
//		String s2=null;
//		System.out.println(s2.toUpperCase());
		
		// three ways to create object
		// of , ofNullable,isEmpty
		String s1=null;
		Optional<String> opt=Optional.ofNullable(s1);
		if(opt.isPresent())
		{
			// s1.toUppercase();
		System.out.println(opt.get().toUpperCase());
		}
		else
		{
			System.out.println("null");
				
		}
//		Returns an Optional with the specified present non-null value.
		Optional<String> opt1=Optional.of("new");
		System.out.println(opt1.orElse("second"));
//		Returns an empty Optional instance.	
		Optional<String> opt2=Optional.empty();
		System.out.println(opt2.orElse("second"));
	}

}
