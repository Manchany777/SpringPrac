package sample05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 파일로 출력해주는 클래스
public class FileOutputter implements Outputter {
	private String filePath;
	private String fileName;
	
	public FileOutputter() {
		System.out.println("FileOutputter 기본 생성자");
	}
	
	public void setFilePath(String filePath) {
		System.out.println("public void setFilePath(String filePath)");
		this.filePath = filePath;
	}
	
	public void setFileName(String fileName) {
		System.out.println("public void setFileName(String fileName)");
		this.fileName = fileName;
	}

	@Override
	public void output(String message) {
		System.out.println("public void output(String message)");
		
		// Writer는 추상메소드라 자식메소드로 Override
		//FileWriter fileWriter = new FileWriter(filePath + fileName); // 해당 경로를 문자열로 묶어서 출력
		try {
			FileWriter fileWriter = new FileWriter(new File(filePath, fileName)); // 해당 경로에 진짜 파일로 생성
			fileWriter.write(message);
			fileWriter.close(); // 파일 생성 완료 (Writer는 2byte 단위라서 한글 안깨지고 해당 경로에 잘 생성됨)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //try-catch
	}
}
