package oo12.files;

import java.io.File;
import java.util.ArrayList;

public class FileSearchRunnable implements Runnable {

    private final File rootDir;
    private final String fileName;
    private volatile boolean stop = false;
    private final ArrayList<FileSearchRunnable> runnables;
    private final FileSearchRunnable parentRunnable;

    public FileSearchRunnable(File rootDir, String fileName, FileSearchRunnable runnable) {
        this.rootDir = rootDir;
        this.fileName = fileName;
        this.runnables = new ArrayList<>();
        this.parentRunnable = runnable;
    }

    @Override
    public void run() {
        if(!stop) {
            File[] files = rootDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if(stop) break;
                    if (file.getName().equals(fileName)) {
                        System.out.println("Found at: " + file.getAbsolutePath());
                        stop();
                    } else if (file.isDirectory()) {
                        runnables.add(startNew(file, fileName, this));
                    }
                }
            }
        }
        System.out.println("Thread done");
    }

    public void stop() {
        stop = true;

        for(FileSearchRunnable runnable : runnables) {
            try {
                runnable.stop();
            } catch (StackOverflowError e) {
                //ignore, just tried to stop and it didn't work
            }
        }

        if(parentRunnable != null)
            parentRunnable.stop();
    }

    public static FileSearchRunnable startNew(File rootDir, String fileName) {
        return startNew(rootDir, fileName, null);
    }

    public static FileSearchRunnable startNew(File rootDir, String fileName, FileSearchRunnable parentRunnable) {
        FileSearchRunnable runnable = new FileSearchRunnable(rootDir, fileName, parentRunnable);
        Thread t = new Thread(runnable);
        t.start();
        return runnable;
    }

}