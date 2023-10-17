package lab2;

public class Student {

	private int totalHoursToTake;

	public Student() {

	super();

	this.totalHoursToTake = 120;

	}

	public Student(int totalHoursToTake) {

	super();

	this.totalHoursToTake = totalHoursToTake;

	}

	public int getTotalHoursToTake() {

	return totalHoursToTake;

	}

	public void setTotalHoursToTake(int totalHoursToTake) {

	this.totalHoursToTake = totalHoursToTake;

	}

	public int hoursLeft() {

	return this.totalHoursToTake;

	}
	
	
}