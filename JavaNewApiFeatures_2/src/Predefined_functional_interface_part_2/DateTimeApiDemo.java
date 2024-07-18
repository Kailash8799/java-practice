package Predefined_functional_interface_part_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeApiDemo {
	// date time api in java 8 is immutable, threadsafe
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		LocalDate d=LocalDate.now();	
		System.out.println(d);
		LocalDate d1=LocalDate.of(1989, 12, 15);	
		
		System.out.println(d1);
		LocalDate d2=LocalDate.of(1989, Month.DECEMBER, 15);	
		
		System.out.println(d2);
		LocalTime t=LocalTime.now();
		System.out.println(t);
		LocalTime t1=LocalTime.of(20,12,55);
		System.out.println(t1);
	
		LocalTime t11=t1.plusHours(5);
		System.out.println(t11);
		
		LocalTime t2=LocalTime.now(ZoneId.of("GMT"));
		System.out.println(t2);
		
		LocalDateTime t3=LocalDateTime.now();
		System.out.println(t3);
		
		System.out.println(ZonedDateTime.now());   
}}
