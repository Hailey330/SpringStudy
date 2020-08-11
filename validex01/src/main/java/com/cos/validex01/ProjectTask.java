package com.cos.validex01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class ProjectTask {

	// 어노테이션 공부하기
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 10, message = "Summary cannot exceed the length")
	@NotBlank(message = "Summary cannot be blank")
	private String summary;
	// @Column(nullable = false) → validation 체크할 때는 문제 없지만 DB에 insert 시 문제 발생
	@NotBlank(message = "AcceptanceCriteria cannot be blank")
	private String acceptanceCriteria;
	private String status;
	
	// model은 데이터를 받는 공간이 아니라 DB 테이블의 속성을 명시하는 곳!
	// 그래서 Dto를 페이지마다 다 만들어야 한다. → 거기 안에 validation 체크
	// model에는 setter가 있으면 안됨. getter만 붙여야 함 그래서 @Data 붙이면 안됨!
	// setter는 생성자, 데이터베이스에서 들고온 정보만 넣을 때 setter 
}
