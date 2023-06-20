/**
 * Class that tests Student and StudentDirectory. You need to fix
 * Student and StudentDirectory to pass these test cases.
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class CS1Test {
	private static int test = 0;
	private static final int NUM = 13;
	private static void test(String info){
		System.out.print("("+test+++"/"+NUM+") "+info+":\t");
	}
	private static void pass(){
		System.out.println("PASSED");
	}
	private static void error(String error){
		System.out.println("FAILED " + error);
		System.exit(-1);
	}
	public static void main (String[] args) {
		test("assertions enabled");
		try{
			assert false;
			error("Assertions not enabled");
		}catch(AssertionError ae){
			pass();
		}
		boolean pass = false;
		String errorMsg = "", className = "", methodName = "", paramsStr = "", fullName = "";
		
		try{
			className = "Student";
			Field[] fields = Student.class.getDeclaredFields();
			test("field access");
			for(Field f:fields){
				if(Modifier.isPublic(f.getModifiers())){
					throw new IllegalAccessError(className+"."+f.getName());
				}
			}
			pass();
			
			Class params[] = new Class[0];
			methodName="Student";
			fullName = className+"."+methodName+"("+paramsStr+")";
			test("no-arg constructor");
			Constructor defaultCon = Student.class.getDeclaredConstructor(params);
			Student empty = (Student)defaultCon.newInstance();
			pass();
			test("default fields are not null");
			assert empty.getGiven()!=null && empty.getFamily()!=null &&
					empty.getGrades()!=null : "Name or Grades is null";
			pass();
			
			params = new Class[4];params[0] = String.class;params[1]=String.class;
			params[2] = int.class;params[3] = String[].class;
			paramsStr = "String,String,int,String[]";
			Constructor fancyCon = Student.class.getDeclaredConstructor(params);
			String[]grades = {"100","100","100","100"};
			
			test("name format = \"FAMILY, given\"");
			Student connie = (Student)fancyCon.newInstance("cOnNiE", "maHESwaran", 10, grades);
			assert connie.getGiven().equals("connie"): "Expected <connie> but was <"+connie.getGiven()+">";
			assert connie.getFamily().equals("MAHESWARAN"): "Expected <MAHESWARAN> but was <"+connie.getFamily()+">";
			pass();
			
			test("constructor invalid parameters");
			grades = null;
			Student temp =null;
			try{
				temp = (Student)fancyCon.newInstance(null, null, 0, null);
				assert temp.getGiven()!=null && temp.getFamily()!=null && temp.getGrades()!=null: "Name or Grades is null in "+methodName+"("+paramsStr+")";
			}catch(InvocationTargetException ite){
				error(ite.getCause().getClass().getSimpleName());
			}
			pass();
			
			test("security of grades");
			methodName = "getGrades";
			paramsStr = "";
			fullName = className + "." + methodName+"("+paramsStr+")";
			String[] grades2 = connie.getGrades();
			for(int i =0;i<grades2.length;i++){
				grades2[i] = "0";
			}
			assert connie.average()>=99.9 : "Someone was able to tamper with Connie's grades.";
			pass();
			
			className = "StudentDirectory";methodName = "buildDirectory";paramsStr = "String";
			fullName = className + "." + methodName+"("+paramsStr+")";
			Student[] students = null;
			try{
				Class c = Class.forName("StudentDirectory");
				Method buildDirectory = c.getMethod("buildDirectory", String.class);
				test("buildDirectory modifier");
				Object[]params2 = new Object[1];
				String x = null;
				params2[0] = x;
				assert Modifier.isStatic(buildDirectory.getModifiers()): "Method is instance method";
				pass();
				
				test("buildDirectory null param");
				try{
					buildDirectory.invoke(null, params2);
				}catch(InvocationTargetException ite){
					assert ite.getCause() instanceof IllegalArgumentException: fullName+" expected <IllegalArgumentException> but was <"+ite.getCause().getClass().getSimpleName()+">";
				}
				pass();
				
				test("buildDirectory FNFE");
				params2[0]= "asdf.txt";
				try{
					buildDirectory.invoke(null, params2);
					throw new Exception("No FileNotFoundException thrown");
				}catch(InvocationTargetException ite){
					assert ite.getCause() instanceof FileNotFoundException: fullName+" expected <FileNotFoundException> but was <"+ite.getCause().getClass().getSimpleName()+">";
				}catch(Exception e){
					error("No FileNotFoundException thrown");
				}
				pass();
				
				test("created directory");
				params2[0] = "students.txt";
				students = (Student[])buildDirectory.invoke(null, params2);
				for(Student s:students){
					assert s != null: "null Student in directory. ";
					assert temp.getFamily().compareTo(s.getFamily()) < 0: "Students are not in order";
					temp = s;
				}
			}catch(InvocationTargetException ite){
				assert false : ite.getCause();
			}catch(ClassNotFoundException cnfe){
				assert false : "Could not find StudentDirectory";
			}catch(Exception e){
				String exName = e.getClass().getSimpleName();
				assert exName.equals("IllegalArgumentException"): fullName+" expected <IllegalArgumentException> but was <"+exName+">";
			}
			pass();
			
			test("printDirectory modifier");
			methodName = "printDirectory";paramsStr = "Student[]";
			fullName = className + "." + methodName+"("+paramsStr+")";
			try{
				Class c = Class.forName("StudentDirectory");
				Method printDirectory = c.getMethod("printDirectory", Student[].class);
				Object[]params2 = new Object[1];
				Student[] x = null;
				params2[0] = x;
				assert Modifier.isStatic(printDirectory.getModifiers()): "Method is instance method";
				pass();
				
				test("printDirectory null param");
				try{
					printDirectory.invoke(null, params2);
				}catch(InvocationTargetException ite){
					assert ite.getCause() instanceof IllegalArgumentException: fullName+" expected <IllegalArgumentException> but was <"+ite.getCause().getClass().getSimpleName()+">";
				}
				pass();
				
				test("printDirectory output");
				params2[0] = students;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PrintStream original = System.out, record = new PrintStream(baos);
				System.setOut(record);
				try{
					printDirectory.invoke(null, params2);
				}catch(InvocationTargetException ite){
					record.flush();
					System.setOut(original);
					record.close();
					error(ite.getCause().toString());
				}
				record.flush();
				System.setOut(original);
				record.close();
				try{
					String actual = baos.toString(), expected  = Files.readString(Path.of("expected.txt"));
					String copyActual = actual, copyExpected = expected;
					actual = actual.replaceAll("\\r|\\n", "");
					expected = expected.replaceAll("\\r|\\n", "");
					assert expected.equals(actual) : "Expected\n"+copyExpected+"\nBut was\n"+copyActual;
				}catch(IOException ioe){
					throw ioe;
				}
			}catch(NullPointerException e){
				String exName = e.getClass().getSimpleName();
				assert exName.equals("IllegalArgumentException"): fullName+" expected <IllegalArgumentException> but was <"+exName+">";
			}catch(ArrayIndexOutOfBoundsException aioobe){
				error("Index out of bounds");
			}catch(Exception e){
				throw e;
			}
			pass();
			
			pass = true;
		}catch(IllegalArgumentException iae){
			errorMsg = "Invalid argument in method "+fullName;
		}catch(NoSuchMethodException nsme){
			errorMsg = "Could not find method "+fullName;
		}catch(IllegalAccessError iae){
			errorMsg = "Field "+iae.getMessage()+" is public";
		}catch(InstantiationException ie){
			errorMsg = "Could not create instance of " + className;
		}catch(IllegalAccessException iae){
			errorMsg = "Could not call "+fullName;
		}catch(InvocationTargetException ite){
			errorMsg = "Could not call "+fullName;
		}catch(AssertionError ae){
			errorMsg = ae.getMessage();
		}catch(FileNotFoundException fnfe){
			errorMsg = "Could not find file.";
		}catch(NoSuchElementException nsee){
			errorMsg = "No such element";
		}catch(IOException ioe){
			errorMsg = "Missing expected output to compare with actual.";
		}catch(ClassNotFoundException cnfe){
			errorMsg = "Class Not Found";
		}
		if(!pass){
			error(errorMsg);
		}
		System.out.println("All tests passed.");
	}
}
