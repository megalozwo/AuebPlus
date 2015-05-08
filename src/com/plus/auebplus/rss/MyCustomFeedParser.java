package com.plus.auebplus.rss;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.util.Log;
 
public class MyCustomFeedParser extends BaseFeedParser {
 
	public String[] urls=new String[10];
	public Context context;
	
    public MyCustomFeedParser(String feedUrl) {
        super(feedUrl);
        urls[0]=feedUrl;
        // TODO Auto-generated constructor stub
    }
 
    public List<Message> parse() {
        
    	String urlStr = urls[0];
		InputStream is = null;
		
		List<Message> messages = null;
		 
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
 
 
        try {
        	URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			//connection.setReadTimeout(10 * 1000);
			//connection.setConnectTimeout(10 * 1000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.connect();
			int response = connection.getResponseCode();
			Log.d("debug", "The response is: " + response);
			is = connection.getInputStream();
			
			//Old
        	factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();
 
            // auto-detect the encoding from the stream
            parser.setInput(is, null);
            //if it fails, the encoding can be passed as input: parser.setInput(this.getInputStream(), "UTF-8");
 
            //what is my event type? start tag, end tag, etc
            int eventType = parser.getEventType();
 
            Message currentMessage = null;
            boolean done = false;
 
            while (eventType != XmlPullParser.END_DOCUMENT && !done){
 
                String name = null;
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        messages = new ArrayList<Message>();
                        break;
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase(T_ITEM)){
                            currentMessage = new Message();
                        } else if (currentMessage != null){
                            if (name.equalsIgnoreCase(T_LINK)){
                                currentMessage.setLink(parser.nextText());
                            } else if (name.equalsIgnoreCase(T_DESCRIPTION)){
                                currentMessage.setDescription(parser.nextText());
                            } else if (name.equalsIgnoreCase(T_PUB_DATE)){
                                currentMessage.setDate(parser.nextText());
                            }
                            else if (name.equalsIgnoreCase(T_TITLE)){
                                currentMessage.setTitle(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        name = parser.getName();
                        if (name.equalsIgnoreCase(T_ITEM) && currentMessage != null){
                            messages.add(currentMessage);
                        } else if (name.equalsIgnoreCase(T_CHANNEL)){
                            done = true;
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }
   
}
