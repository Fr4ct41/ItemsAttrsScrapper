package Application.other;

import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;

public class HtmlParser {
    private final Map<String,String> cookies;
    private final Map<String,String> headers;
    private final Proxy proxy;
    private final URL url;

    public HtmlParser(Map<String, String> cookies, Map<String, String> headers, Proxy proxy, URL url) {
        this.cookies = cookies;
        this.headers = headers;
        this.proxy = proxy;
        this.url = url;
    }

    public Document getHtml() throws IOException {
        Connection connection = new HttpConnection()
                .url(url)
                .headers(headers)
                .referrer("https://google.com")
                .cookies(cookies)
                .proxy(proxy);
        return connection.get();
    }
}
