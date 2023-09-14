package sample04;

public class SungJukOutput implements SungJuk {
	private SungJukDTO2 sungJukDTO2;
	
	public SungJukOutput(SungJukDTO2 sungJukDTO2) {
		super();
		this.sungJukDTO2 = sungJukDTO2;
	}

	@Override
	public void execute() {
		System.out.println();
		System.out.println("이름	국어	영어	수학	총점	평균");
		System.out.println(sungJukDTO2);
		System.out.println();
	}
}
