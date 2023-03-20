
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url =  "https://www.pkaymetal.com/careers";
		
		crawl(1,url, new ArrayList<String>());

	}
	
	public static void crawl(int level, String url, ArrayList<String> visited) {
		
		if(level<=5) {
			
			Document doc = request(url, visited);
			if(doc!=null) {
				for(Element link : doc.select("a[href]")) {
					String next_link = link.absUrl("href");
					if(visited.contains(next_link)==false) {
						crawl(level++, next_link, visited);
					}
				}
			}
			
			
		}
	}
	
	private static Document request(String url, ArrayList<String> v) {
		try {
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			System.out.println(doc.html());
		
			return null;
		}
		catch(IOException e) {
			return null;
			
		}
		
	}
   
}
