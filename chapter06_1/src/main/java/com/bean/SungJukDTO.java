package com.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SungJukDTO {
	private String name;
	private int kor; 
	private int eng; 
	private int math; 
	private int tot;
	private int avg;
}