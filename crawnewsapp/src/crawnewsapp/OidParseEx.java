package crawnewsapp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// 1번 Jsoup(Maven)
// 2번 Jsoup로 URL 요청하기
// 3번 oid의 번호는 어디까지 있는지 찾기 & oid 신문사명을 매칭하기  

public class OidParseEx {

//		Map<String, Integer> oidMap = new HashMap<>();

	public static void main(String[] args) {

		String url = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&";
		String oid = "001";
		String aid = "0003783001";
		Document doc;
		String newsUrl;

		// 2번 URL 요청하기
		try {
			while (true) {
				newsUrl = url + "&oid=" + oid + "&aid=" + aid;
				doc = Jsoup.connect(newsUrl).get();
				Elements element = doc.select("div.article_header");
				Elements press = element.select("img");
				String pressname = press.attr("title");
				System.out.println("언론사 : " + pressname);

				Elements header = element.select("div.article_info");
				String title = header.select("h3").text();
				System.out.println("기사 제목 : " + title);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void increment() {
//		for (int i = 0; i < 1000; i++) {
//			int oidNum = i;
//			if (oidNum < 10) {
//				oidNum = "00" + Integer.toString(oidNum);
//			}
//			
//		}

}
