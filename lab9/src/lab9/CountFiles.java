package lab9;

import java.io.File;

public class CountFiles {
    public static void main(String[] args) {
        File rootDirectory = new File("/usr/bin");

        System.out.println(countFile(rootDirectory));
    }

    public static int countFile(File f) {
        int count = 0;

        if (!f.isDirectory()) {
            // Base case: f is a file, so just print its name
            return 1;
        } else {
            // Recursive case: f is a directory, so go through the
            // files and directories it contains, and recursively call
            // this method on each one
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; ++i) {
                count += countFile(files[i]);
            }
        }

        return count;
    }
}