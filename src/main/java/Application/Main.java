package Application;

import Application.dataparsers.SteamAttributesParser;
import Application.other.HtmlParser;

import java.io.IOException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Map<String,String> cookies = new HashMap<>();
        cookies.put("Steam_language","russian");

        URL url = new URI("https://steamcommunity.com/market/search?appid=730").toURL();

        Map<String,String> headers = new HashMap<>();

        HtmlParser htmlParser = new HtmlParser(cookies,headers,null,url);
        var parser = new SteamAttributesParser(htmlParser);
        System.out.println((parser.getAttrs()));
    }
}