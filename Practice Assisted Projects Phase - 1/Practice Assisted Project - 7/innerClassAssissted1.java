package innerClass;

public class innerClassAssissted1 {

	private String msg="Welcome to Java"; 
	 
	 class Inner{  
	  void hello(){System.out.println(msg+", Let us start learning Inner Classes");}  
	 }  


	public static void main(String[] args) {

		innerClassAssissted1 obj=new innerClassAssissted1();
		innerClassAssissted1.Inner in=obj.new Inner();  
		in.hello();  
	}
}
