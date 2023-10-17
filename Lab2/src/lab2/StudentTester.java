package lab2;

public class StudentTester {

	public static void main(String[] args) {
		
		Student jim = new Student(120);
		CSStudent kim = new CSStudent(120,20,24);

		System.out.println("Jim's Remaining Hours: " + jim.hoursLeft());
		System.out.println();
		System.out.println("Kim's Remaining Hours: " + kim.hoursLeft());

	}

}
