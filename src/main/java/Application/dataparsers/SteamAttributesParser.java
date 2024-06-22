package Application.dataparsers;

import Application.other.HtmlParser;
import Application.other.JsonReader;
import com.fasterxml.jackson.databind.JsonNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class SteamAttributesParser {
    private final HtmlParser parser;

    public SteamAttributesParser(HtmlParser parser) {
        this.parser = parser;
    }

    private String compareString(String rawString){
        for (String subStr: rawString.split("\n")){
            if (subStr.contains("g_rgFilterData")){
                int jsonBegin = subStr.indexOf('{');
                return subStr.substring(jsonBegin);
            }
        }
        return null;
    }
    public JsonNode getAttrs(){
        try {
            Document document = parser.getHtml();
            Element attrsTag = document.select("script").last();
            String jsonStr = compareString(attrsTag.toString());
            return new JsonReader().readFromString(jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
