package chapter11_ObjectsCreatingAndUsing;


public class Exr01_timeAndDateCounting {

	public static void main(String[] args) {
		// TODO Print the number of dates, hours and minutes elapsed from 01.01.1970 to now
		long miliSeconds = System.currentTimeMillis();
		
		System.out.println("Miliseconds elapsed from 1.01.1970: " + miliSeconds);
		System.out.println("Seconds elapsed from 1.01.1970: " + miliSeconds/1000);
		System.out.println("Minudes elapsed from 1.01.1970: " + miliSeconds/(1000*60));
		System.out.println("Hours elapsed from 1.01.1970: " + miliSeconds/(1000*60*60));
		System.out.println("Days elapsed from 1.01.1970: " + miliSeconds/(1000*60*60*24));	

	}

}
