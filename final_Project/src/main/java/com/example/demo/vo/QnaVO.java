package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnaVO {

	private int qna_no;
	private int detail_no;
	private String qna_title;
	private String qna_content;
	private String qna_img;
	private Date qna_date;
	private String qna_answer;
}
