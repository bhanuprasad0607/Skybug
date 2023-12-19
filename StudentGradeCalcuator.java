import java.util.Scanner;

public class StudentGradeCalcuator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter English marks");
		float Emarks = sc.nextFloat();
		
		System.out.println("Enter First language marks");
		float Fmarks = sc.nextFloat();
		
		System.out.println("Enter Second language marks");
		float Smarks = sc.nextFloat();
		
		System.out.println("Enter Maths marks");
		float Mmarks = sc.nextFloat();
		
		System.out.println("Enter Physics marks");
		float Pmarks = sc.nextFloat();
		
		System.out.println("Enter Chemistry marks");
		float Cmarks = sc.nextFloat();
		
		System.out.println("Enter Biology marks");
		float Bmarks = sc.nextFloat();
		
		float sum = Emarks+Fmarks+Smarks+Mmarks+Pmarks+Cmarks+Bmarks;
		float percentage = sum/6;
		
		String  grade = "O";
		if(percentage>=90 && percentage<=10 ) {
			grade = "O";
			
		}else if(percentage>=80 && percentage<=89) {
			grade = "A+";
			
		}else if(percentage>=70 && percentage<=79) {
			grade = "A";
			
		}else if(percentage>=60 && percentage<=69) {
			grade = "B+";
			
		}else if(percentage>=50 && percentage<=59) {
			grade = "B";
			
		}else if(percentage>=40 && percentage<=49) {
			grade = "C";
			
		}else if(percentage<40) {
			grade = "F";
			
		}
		
		System.out.println("You have got total "+sum+" marks");
		System.out.println("The average marks percentage is "+percentage+"%");
		if(Emarks<40 || Fmarks<40 || Smarks<40 || Mmarks<40 || Pmarks<40 || Cmarks<40 || Bmarks<40) {
			System.out.println("You failed in one sunject \nSo the grade is F");
		}else {
			System.out.println("And you have obtained  "+grade+" Grade");
			
		}
		

	}

}
