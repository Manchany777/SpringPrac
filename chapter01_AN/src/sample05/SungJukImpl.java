package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	Scanner scan = new Scanner(System.in);
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
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
		this.tot = this.kor + this.eng + this.math;
		this.avg = (double)(tot)/3;
		
		display();
	}

	@Override
	public void display() {
		System.out.println("이름	국어	영어	수학	총점	평균");
		System.out.println(name+ "\t" + kor+ "\t" + eng+ "\t" + math 
				+ "\t" + tot + "\t" + String.format("%.2f", avg));
	}
}
