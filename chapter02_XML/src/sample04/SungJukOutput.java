package sample04;

import java.util.ArrayList;

import lombok.Setter;

public class SungJukOutput implements SungJuk {
	@Setter
	private ArrayList<SungJukDTO2> list;

	@Override
	public void execute() {
		System.out.println();
		System.out.println("이름	국어	영어	수학	총점	평균");
		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2);
		}
		System.out.println();
	}
}
