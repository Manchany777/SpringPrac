package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	Scanner scan = new Scanner(System.in);
	
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	double avg;
	
	public SungJukImpl() {
		System.out.println();
		System.out.println("*************");
		System.out.print("이름 입력 : ");
		this.name = scan.next();
		System.out.print("국어 입력 : ");
		this.kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		this.eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		this.math = scan.nextInt();
		System.out.println();
	}
	
	@Override
	public void calc() {
		this.tot = kor + eng + math;
		this.avg = (double)(kor + eng + math)/3;
		
		display();
	}

	@Override
	public void display() {
		System.out.println("이름	국어	영어	수학	총점	평균");
		System.out.println(name+ "\t" + kor+ "\t" + eng+ "\t" + math 
				+ "\t" + tot + "\t" + String.format("%.2f", avg));
	}
}
