package sample04;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukDTO2 {
	private String name; 
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	

	public String getName() {
		return name;
	}
	
	@Autowired
	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	@Autowired
	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}

	@Autowired
	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}
	
	@Autowired
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTot() {
		return tot;
	}

	@Autowired
	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}
	@Autowired
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + 
			   eng + "\t" + math + "\t" + 
			   tot + "\t" + String.format("%.2f", avg);
	}
}
