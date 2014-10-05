

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

/**
 * Parser class is used to parse HTML pages and extract hyperlinks
 */
public class Parser {
    private String mContent;
    private ArrayList<String> mHyperlinks;

    public Parser(String content) {
        mContent = content;
    }

    public ArrayList<String> getHyperlinks() {
        if (mHyperlinks == null) {
            mHyperlinks = new ArrayList<String>();

            Document doc = Jsoup.parse(mContent);

            for (Element link : doc.select("a[href]")) {
                String url = link.attr("href");

                if (url.length() > 0)
                    mHyperlinks.add(url);
            }
        }

        return mHyperlinks;
    }
}
