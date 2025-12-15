// File: MarvellousPacker.java
import java.io.*;
import java.util.*;

public class MarvellousPacker {
    FileOutputStream outstream = null;

    public MarvellousPacker(String folderPath, String outputFile) {
        try {
            File outfile = new File(outputFile);
            outstream = new FileOutputStream(outfile);

            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files == null) {
                System.out.println("Invalid folder path.");
                return;
            }

            for (File f : files) {
                packFile(f.getAbsolutePath());
            }

            System.out.println("Packing completed!");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void packFile(String filePath) {
        try {
            File infile = new File(filePath);
            FileInputStream instream = new FileInputStream(infile);
            byte[] buffer = new byte[(int) infile.length()];
            instream.read(buffer, 0, buffer.length);

            // Header format: filename (padded) + file size
            String header = filePath + " " + buffer.length;
            header = String.format("%-100s", header); // pad to 100 bytes

            byte[] headerBytes = header.getBytes();
            outstream.write(headerBytes);
            outstream.write(buffer);

            instream.close();
        } catch (Exception e) {
            System.out.println("Error packing file: " + e);
        }
    }
}
