package com.cos.securityex01.config.oauth.provider;

import java.util.Map;

// 2. implements
public class NaverUserInfo implements OAuth2UserInfo {

	// 1. 전역 선언
	private Map<String, Object> attributes;

	// 3. 생성자 만들기
	public NaverUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	// 4. override
	@Override
	public String getProviderId() {
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		return (String) response.get("id");
	}

	@Override
	public String getProvider() {
		return "naver";
	}

	@Override
	public String getName() {
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		return (String) response.get("name");
	}

	@Override
	public String getEmail() {
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		return String.valueOf(response.get("email"));
	}

}
