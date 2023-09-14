package sample02;

public class CalcAdd implements Calc {
	private int x;
	private int y;
	
	public CalcAdd(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
}
