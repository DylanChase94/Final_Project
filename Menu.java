//class Menu

import java.util.Scanner;

public class Menu{
	private int n;

	public Menu(){
		int n=0;
}
	public static void main(String[]args){
	Scanner s=new Scanner(System.in);
	System.out.println("Enter 1 for Admin or 2 for Customer");

   int n=s.nextInt();
   
	if(n==1){
		System.out.println("This is the Admin page");
	}
	else if(n==2){
		System.out.println("This is the Customer page");
	}
	else{
		System.out.println("You did not enter 1 or 2");
	}
}
}
import java.util.Scanner;

public class bundle{

	private String name;
	private int grade;

	public bundle(String name0, int grade0){
        name = name0;
        grade = grade0; 
    }
    public static void fillArray(student[] args){
    	Scanner scan = new Scanner(System.in);  // Reading from System.in
		for (int i=0; i<5; i++);
		{
    		 
				System.out.println("Enter a name: ");
				String s = scan.nextLine();
				System.out.println("Enter a grade: ");
				int x = scan.nextInt();
				student stu1 = new student(s,x);
				args[i] = stu1;
    	}
    }

	public static void main(String[] args){
		student[] myStudentArray = new student[5];
		fillArray(myStudentArray);
	}

	
}
	
}

