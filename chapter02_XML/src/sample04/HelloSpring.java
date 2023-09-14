package sample04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    SungJuk sungJuk = null;

    public void menu(ApplicationContext applicationContext) {
        Scanner scan = new Scanner(System.in);
        int num = 0;

        while (true) {
            System.out.println("*************");
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 끝");
            System.out.println("*************");
            System.out.print("번호 입력 : ");
            num = scan.nextInt();

            if (num == 1) {
                sungJuk = applicationContext.getBean("sungJukInput", SungJuk.class);
            } else if (num == 2) {
                sungJuk = applicationContext.getBean("sungJukOutput", SungJuk.class);
            } else if (num == 3) {
                sungJuk = applicationContext.getBean("sungJukUpdate", SungJuk.class);
            } else if (num == 4) {
                sungJuk = applicationContext.getBean("sungJukDelete", SungJuk.class);
            } else if (num == 5) {
                System.out.println("프로그램 종료");
                break;
            }

            sungJuk.execute();
        }
        scan.close();
    }

    public static void main(String[] args) {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    	HelloSpring helloSpring = (HelloSpring)applicationContext.getBean("helloSpring");
        helloSpring.menu(applicationContext);
    }
}