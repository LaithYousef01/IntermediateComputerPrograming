package lab2;

public class CSStudent extends Student{
	
	private int genEdHours;

	private int mathHours;

	public CSStudent() {

	super();


	}

	public CSStudent(int totalHoursToTake,int genEdHours,int mathHours) {

	super(totalHoursToTake);


	this.genEdHours = genEdHours;

	this.mathHours = mathHours;

	}

	public int getGenEdHours() {

	return genEdHours;

	}

	public void setGenEdHours(int genEdHours) {

	this.genEdHours = genEdHours;

	}

	public int getMathHours() {

	return mathHours;

	}

	public void setMathHours(int mathHours) {

	this.mathHours = mathHours;

	}

	

	public int hoursLeft() {

	

	return getTotalHoursToTake() - genEdHours - mathHours;

	}

}
