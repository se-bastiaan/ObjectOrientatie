package oo12.files;

import java.io.File;
import java.io.IOException;

/**
 * Main test class
 */
public class FileFinderTest {

    public FileFinderTest() {
        try {
            String goal = "FileFinder.java";
            File root = new File("/Users/Sebastiaan/Google Drive/Universiteit/Propedeuse/Object Oriëntatie/");
            FileFinder ff = new FileFinder(root);
            ff.findFile(goal);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        FileFinderTest fft = new FileFinderTest();
    }
}