package com.dagong.develop;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * 使用Jsoup抓取页面的数据
 * 
 * @author DAGONG
 *
 */
public class JsoupTest {

	static String url="http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html";
	@Test
	public void test() throws IOException{
		//BlogBody();
		//article();
		Blog();
	}
	
	/**
	 * 获取指定的HTML文档指定的body
	 * @throws IOException 
	 * 
	 */
	private static void BlogBody() throws IOException {
		//直接从字符串中输入HTML文档
		String html="<html><head><title> 开源中国社区 </title></head>"
				+ "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
		Document doc=Jsoup.parse(html);
		System.out.println(doc.body());
		
		//从URL直接加载HTML文档
		Document doc2=Jsoup.connect(url).get();
		String title=doc2.body().toString();
		System.out.println(title);
	}	
	
	/**
	 * 获取博客上的文章和链接
	 * @throws IOException 
	 */
	public static void article() throws IOException{
		Document doc;
		doc=Jsoup.connect("http://www.cnblogs.com/zyw-205520").get();
		Elements listDiv = doc.getElementsByAttributeValue("class","postTitle");
		for (Element  element  : listDiv) {
			 Elements links = element.getElementsByTag("a");
			 for (Element link : links) {
                 String linkHref = link.attr("href");
                 String linkText = link.text().trim();
                 System.out.println(linkHref);
                 System.out.println(linkText);
		}
	}
	}
	/**
	 * 获取指定博客文章的内容
	 * @throws IOException 
	 */
	public static void Blog() throws IOException{
		Document doc;
		doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html").get();
		Elements listDiv=doc.getElementsByAttributeValue("class", "postBody");
		for (Element element : listDiv) {
			System.out.println(element.html());
		}
	}
}
