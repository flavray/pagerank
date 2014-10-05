package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Parser class is used to parse HTML pages and extract hyperlinks
 */
public class Parser {
    private String mContent;
    private ArrayList<String> mHyperlinks;

    /**
     * Creates a new HTML parser
     * @param filepath the HTML file to parse
     */
    public Parser(String filepath) {
        try {
            mContent = readFile(filepath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all the hyperlinks present in the HTML
     * @return the hyperlinks
     */
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

    private String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }

            return sb.toString();
        } finally {
            br.close();
        }
    }
}
