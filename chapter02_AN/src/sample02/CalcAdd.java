package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalcAdd implements Calc {
	
	private int x;
	private int y;
	
	public CalcAdd(@Value("20") int x,@Value("30") int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Autowired
	public void setX(@Value("68") int x) {
		this.x = x;
	}
	@Autowired
	public void setY(@Value("35") int y) {
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
}