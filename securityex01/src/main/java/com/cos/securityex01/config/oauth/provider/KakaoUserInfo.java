package com.cos.securityex01.config.oauth.provider;

import java.util.Map;

// 2. implements
public class KakaoUserInfo implements OAuth2UserInfo {

	// 1. 전역 선언
	private Map<String, Object> attributes;

	// 3. 생성자 만들기
	public KakaoUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	// 4. override
	@Override
	public String getProviderId() {
		return String.valueOf(attributes.get("id"));
	}

	@Override
	public String getProvider() {
		return "kakao";
	}

	@Override
	public String getName() {
		Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
		return String.valueOf(properties.get("nickname"));
	}

	@Override
	public String getEmail() {
		Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");
		return String.valueOf(kakao_account.get("email"));
	}

}
