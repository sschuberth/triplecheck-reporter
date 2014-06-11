package ThirdParty.vogella;


public class ReadTest {
	public static void main(String[] args) {
		RSSFeedParser parser = new RSSFeedParser(
				"http://triplecheck.de/feed");
		Feed feed = parser.readFeed();
		//System.out.println(feed);
		for (FeedMessage message : feed.getMessages()) {
			System.out.println(message);

		}

	}
}
