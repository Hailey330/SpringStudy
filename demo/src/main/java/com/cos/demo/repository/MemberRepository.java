package com.cos.demo.repository;

import java.util.List;

import com.cos.demo.model.Member;

public interface MemberRepository {
	public Member findById(int id);
	public List<Member> findAll();
}
