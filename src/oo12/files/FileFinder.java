package oo12.files;

import java.io.File;
import java.io.IOException;

public class FileFinder {

    private final File rootDir;

    public FileFinder(File root) throws IOException {
        rootDir = root;
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }

    public void findFile(String file) {
        find(rootDir, file);
    }

    private void find(File rootDir, String fileName) {
        FileSearchRunnable.startNew(rootDir, fileName);
    }

}