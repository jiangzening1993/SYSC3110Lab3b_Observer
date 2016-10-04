/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;

public class Prof extends Observable {
	private String name;
	private Date midtermDate;

	public Prof(String aName) {
		this.name = aName;
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		setChanged();
		notifyObservers(1);
	}
	
	public void postponeMidterm(Date date){ 
		this.midtermDate = date;
		setChanged();
		notifyObservers(2);
	}
	
	public Date getDate(){
		return midtermDate;
	}


	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addObserver(s);
		p.addObserver(s2);
		p.addObserver(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}