package sample04;

import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	Scanner scan = new Scanner(System.in);
	SungJukDTO2 sungJukDTO2 = null;
	
	@Override
	public void execute() {
		
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		
		if(sungJukDTO2.getName() != name) {
			System.out.println("찾고자하는 이름이 없습니다");
		} else {
			System.out.println(sungJukDTO2.getName() + "님의 데이터를 삭제 하였습니다");
			
		} //if
	}
}
