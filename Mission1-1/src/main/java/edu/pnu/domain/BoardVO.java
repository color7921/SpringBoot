package edu.pnu.domain;

import java.sql.PreparedStatement;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {

	private Integer seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt = 0;
}


