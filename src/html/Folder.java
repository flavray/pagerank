package html;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;


public class Folder {
    private class HTMLFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".html");
        }
    }
    private String mPath;
    private ArrayList<String> mHTMLFiles;

    public Folder(String path) {
        mPath = path;
    }

    public ArrayList<String> getHTMLFiles() {
        if (mHTMLFiles == null) {
            mHTMLFiles = new ArrayList<String>();

            File folder = new File(mPath);
            File[] files = folder.listFiles(new HTMLFileFilter());

            for (int i = 0; i < files.length; ++i)
                mHTMLFiles.add(files[i].getName());
        }

        return mHTMLFiles;
    }
}
