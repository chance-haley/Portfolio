import java.util.*;
public class Ch12Test{

	public static void main (String[] args) {
	
		
		int test1Failed =	testdoubleDigit();
		int test2Failed =	testsumTo();
		int test3Failed =	testpermut();
		int test4Failed =	testsubsets();
		if(test1Failed==0 && test2Failed==0 &&test3Failed==0 &&test4Failed==0){
			System.out.println("All tests passed");
		
		}
		if(test1Failed ==1){
			System.out.println("doubleDigits failed");
		}
		if(test2Failed ==1){
			System.out.println("sumTo failed");
		}
		if(test3Failed ==1){
			System.out.println("permut failed");
		}
		if(test4Failed ==1){
			System.out.println("subsets failed");
		}
		System.out.println("All other tests passed");
	}
	
	
	private static int testdoubleDigit(){
		
		int expected, actual;
		
		int tester = 12345;
		
		expected = 1122334455;
		
		actual = Ch12.doubleDigits(tester);
		
		if(actual==expected) return 0;
		else return 1;
		
		
	}
	private static int testsumTo(){
		
		double expected, actual;
		
		int tester = 2;
		
		expected = 1.5;
		
		actual = Ch12.sumTo(tester);
		
		if(actual==expected) return 0;
		else return 1;
		
	}
	
	private static int testpermut(){
		
		int expected, actual;
		
		expected = 60;
		
		actual = Ch12.permut(5,3);
		
		if(actual==expected) return 0;
		else return 1;
		
		
		
	}
	
	private static int testsubsets(){
		
		//Set<List> expected = new SortedSet<List>();
		
		
		return 1;
	}
	
}
