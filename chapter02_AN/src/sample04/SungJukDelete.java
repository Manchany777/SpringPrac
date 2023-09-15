package sample04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukDelete implements SungJuk {
	@Autowired
	@Qualifier("arrayList") 
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		
		/* for(SungJukDTO2 sungJukDTO2 : list) (x)
		   delete는 list를 쓰면 x - 배열의 요소를 delete하면 index가 바뀌면서 for문이 꼬여서 에러가 떨어짐
		   so, iterator 써야함 */
		
		/* it.hasnext() -> 다음요소가 있는지 T or F로 반환
		   it.next() -> 요소를 꺼내서 버퍼에 보관후 다음 요소로 이동
		   it.remove() -> 버퍼에 있는 요소를 제거 (배열의 it은 이미 다음요소를 가리키기 때문에 오류없이 수행) */
		
		Iterator<SungJukDTO2> it = list.iterator();
		int sw = 0;
		while(it.hasNext()) { // 항목이 있으면 T, 없으면 F
			// it가 가리키는 항목을 꺼내서 저장한 후, it는 다음 항목으로 
			SungJukDTO2 sungJukDTO2 = it.next();
			
			if(sungJukDTO2.getName().equals(name)) {
				sw = 1;
				it.remove(); // 아까 보관항 항목을 제거
				System.out.println(name + "님의 데이터를 삭제 하였습니다");
				
				break; // break 안쓰면 똑같은 이름을 다 지워버린다.
			}
		} // while
		
		if(sw == 0) System.out.println("찾고자하는 이름이 없습니다.");
	}
}
