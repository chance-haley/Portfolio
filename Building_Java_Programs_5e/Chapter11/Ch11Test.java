/**
 * Tester for Chapter 11: Collections
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class Ch11Test {
	public static int testsFailed = 0;
	public static Class ch;
	
	public static void main (String[] args) {
		try{
			assert false;
			throw new Exception("Asserts not enabled");
		}catch(AssertionError ae){
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		String className = "Ch11";
		try{
			ch = Class.forName(className);
			testAlternate();
			testSortAndRemoveDuplicates();
			testHasOdd();
			testIs1to1();
			testStableMarriage();

		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		System.out.println();
		if(testsFailed == 0){
			System.out.println("All tests passed");
		}else{
			System.out.println(testsFailed+ " test(s) failed");
			System.exit(-1);
		}
	}
	public static void assertEquals(Method method, Object expected, Object actual, Object[] params)throws Exception{
		method.invoke(null, params);
		assertEquals(expected, actual);
	}
	
	public static void assertEquals(Method method, Object expected, Object actual)throws Exception{
		Object[] params = new Object[1];
		params[0] = actual;
		assertEquals(method, expected, actual, params);
	}
	public static void assertEquals(Object expected, Object actual){
		assert expected.equals(actual) : "Expected " + expected.toString() + " but was " + actual.toString();
	}
	public static void assertThrows(Method method, String type, Object[]params) throws Exception{
		try{
			method.invoke(null, params);
			throw new Exception("No "+type+" thrown");
		}catch(InvocationTargetException ite){
			String cause = ite.getCause().getClass().getSimpleName();
			if(!cause.equals(type)){
				assert false : "Expected "+type+" but was " + cause;
			}
		}
	}
	public static void assertThrows(Method method, String type, Object param) throws Exception{
		Object[]params = new Object[1];
		params[0] = param;
		assertThrows(method, type, params);
	}
	public static void testAlternate(){
		String methodName = "alternate";
		try{
			Method method = ch.getMethod(methodName, List.class, List.class);
			List<Integer> list1 = new LinkedList<>(List.of(1,2,3,4,5));
			List<Integer> list2 = new LinkedList<>(List.of(6,7,8,9,10,11,12));
			List<Integer> copy1 = new LinkedList<>(list1);
			List<Integer> copy2 = new LinkedList<>(list2);
			Object[]params = new Object[2];
			params[0] = list1; params[1] = list2;
			List<Integer> actual = (List<Integer>)method.invoke(method, params);
			List<Integer> expected = new LinkedList<>(List.of(1,6,2,7,3,8,4,9,5,10,11,12));
			assertEquals(expected, actual);
			assertEquals(copy1, list1);
			assertEquals(copy2, list2);
			
			actual = new ArrayList<>();
			params[0] = actual; params[1] = actual;
			actual = (List<Integer>)method.invoke(null, params);
			expected = new ArrayList<>();
			assertEquals( expected, actual);
					
			expected = list1; params[0] = actual; params[1] = list1;
			actual = (List<Integer>)method.invoke(null, params);
			assertEquals(expected, actual);
			
			params[0] = null;
			assertThrows(method, "IllegalArgumentException", params);
			
			params[1] = null; params[0] = actual;
			assertThrows(method, "IllegalArgumentException", params);
			
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	
	public static void testSortAndRemoveDuplicates(){
		String methodName = "sortAndRemoveDuplicates";
		try{
			Method method = ch.getMethod(methodName, List.class);
			List<Integer> actual = new ArrayList<>(List.of(7,4,-9,4,15,8,27,7,11,-5,32,-9,-9));
			List<Integer> expected = new ArrayList<>(List.of(-9,-5,4,7,8,11,15,27,32));
			assertEquals(method, expected, actual);
			
			actual = new LinkedList<>(List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
			expected = new LinkedList<>(List.of(0));
			assertEquals(method, expected, actual);
			
			actual = new ArrayList<>();
			expected = new LinkedList<>();
			assertEquals(method, expected, actual);
			
			actual = null;
			assertThrows(method, "IllegalArgumentException", actual);			
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage()+" "+ e.getCause());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	
	public static void testHasOdd(){
		String methodName = "hasOdd";
		try{
			Method method = ch.getMethod(methodName, Set.class);
			Object[]params = new Object[1];
			params[0] = new HashSet<Integer>(Set.of(0,1,2,3,4,5,6,7,8,9));
			boolean actual = (boolean)method.invoke(null, params);
			boolean expected = true;
			assertEquals(expected, actual);
			
			params[0] = new TreeSet<Integer>(Set.of(0));
			actual = (boolean)method.invoke(null, params);
			expected = false;
			assertEquals(expected, actual);
			
			params[0] = Set.of();
			actual = (boolean)method.invoke(null, params);
			expected = false;
			assertEquals(expected, actual);
			
			Set<Integer>x = null;
			params[0] = x;
			assertThrows(method, "IllegalArgumentException", params);
			
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage()+" "+ e.getCause());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	
	public static void testIs1to1(){
		String methodName = "is1to1";
		try{
			Method method = ch.getMethod(methodName, Map.class);
			Map<String, String> map = Map.of("Marty", "206-9024", "Hawking", "123-4567", "Smith", "949-0504","Newton", "123-4567");
			Object[]params = new Object[1];
			params[0] = map;
			boolean actual = (boolean)method.invoke(null, params);
			boolean expected = false;
			assertEquals(expected, actual);
			
			map = Map.of("Marty", "206-9024", "Hawking", "555-1234", "Smith", "949-0504","Newton", "123-4567");
			params[0] = map;
			actual = (boolean)method.invoke(null, params);
			expected = true;
			assertEquals(expected, actual);
			
			map = Map.of();
			params[0] = map;
			actual = (boolean)method.invoke(null, params);
			expected = true;
			assertEquals(expected, actual);
			
			map = null;
			params[0] = map;
			assertThrows(method, "IllegalArgumentException", params);
			
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage()+" "+ e.getCause());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	
	public static void testStableMarriage(){
		String methodName = "stableMarriage";
		try{
			File input = new File("stableMarriage.txt");
			Method method = ch.getMethod(methodName, File.class);
			Object[] params = new Object[1];
			params[0] = input;
			String expected = stable.replaceAll("\\r|\\n", "").trim();
			String actual = ((String)method.invoke(method, params)).replaceAll("\\r|\\n", "").trim();
			assertEquals(expected, actual);
			params[0] = null;
			assertThrows(method, "IllegalArgumentException", params);
		}catch(NoSuchMethodException nsme){
			System.out.println("Could not find optional method <public static String "+methodName+"(File)>");
			return;
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage()+" "+ e.getCause());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	
	public static String stable = """
Man 1 and Woman 4
Man 3 and Woman 2
Man 2 and Woman 3
Man 4 and Woman 1
""";
}
