package com.solstice.feedreader.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParserException;

/** The loader to load the XML file. */
public class FeedLoader {

	/** The url to download the xml. */
	private static final String URL = "http://blog.solstice-mobile.com/feeds/posts/default";

	/**
	 * Load the xml from the url.
	 * 
	 * @return The FeedManager used to save articles, authors and categories.
	 * @throws IOException
	 *             The exception when network went wrong.
	 * @throws XmlPullParserException
	 *             The exception when parser xml.
	 */
	public FeedManager loadFeed() throws IOException, XmlPullParserException {
		InputStream stream = null;
		SolsticeXmlParser solsticeXmlParser = new SolsticeXmlParser();

		try {
			stream = downloadUrl(URL);
			return solsticeXmlParser.parse(stream);
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

	/**
	 * Given a string representation of a URL, sets up a connection and gets an
	 * input stream.
	 */
	private InputStream downloadUrl(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10000 /* milliseconds */);
		conn.setConnectTimeout(15000 /* milliseconds */);
		conn.setRequestMethod("GET");
		conn.setDoInput(true);
		// Starts the query
		conn.connect();
		InputStream stream = conn.getInputStream();

		return stream;
	}

}
