package com.cos.review;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

// host 주소 -  http://hare.kr/222065140009 → 상세 내용이 있음
// https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%EA%B0%A4%EB%9F%AD%EC%8B%9C20&sm=tab_pge&srchby=all&st=sim&where=post&start=31
// 썸네일, 블로그 주소, 제목, 날짜 크롤링 해오기 

public class NaverBlogCrawTest {

	private String keyword = null;
	
	@Test
	public void 제품리뷰_크롤링() {
		String keyword = "갤럭시20";
		String url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=" + keyword + "&oquery=" + keyword + "&tqi=Uz8%2BVdp0Jy0ssSIvZC4ssssstyC-061077";
		
		try {
			Document doc = Jsoup.connect(url).get();
			Elements els = doc.select(".blog .sh_blog_top a");
			for (Element el : els) {
				System.out.println(el.attr("title"));
			}
			System.out.println(els);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(url);
	}
}
