package com.cos.validex01;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/board")
public class ProjectTaskController {

	@Autowired // 여기 Autowired 되려면 class 자체도 IoC 되어야 함(@RestController 없으면 안됨)
	private ProjectTaskRepository projectTaskRepository;

	@PostMapping({ "", "/" })
	public ResponseEntity<?> save(@Valid @RequestBody ProjectTask requestProjectTask, BindingResult bindingResult) {

		// DB에 있는 entity 를 받음
		ProjectTask entityProjectTask = projectTaskRepository.save(requestProjectTask);

		RespDto<?> respDto = RespDto.builder()
				.statusCode(StatusCode.OK)
				.msg("save 요청에 성공하였습니다.")
				.data(entityProjectTask)
				.build();

		return new ResponseEntity<RespDto>(respDto, HttpStatus.CREATED);
		// 1, -1, 0 → 정확한 리턴 이유를 모름
		// return new ResponseEntity<Integer>("1")
		// 1 : 정상, 2 : 중복, 3 : 에러 이런 식으로 정하면 됨. 아니면 Http 상태코드 사용할 것
	}
}
