
/*// File: MarvellousUnpacker.java
import java.io.*;

public class MarvellousUnpacker {
    public MarvellousUnpacker(String packedFile) {
        unpackFile(packedFile);
    }

    public void unpackFile(String packedFile) {
        try {
            FileInputStream instream = new FileInputStream(packedFile);
            byte[] header = new byte[100];
            int bytesRead = 0;

            while ((bytesRead = instream.read(header)) != -1) {
                String headerStr = new String(header).trim();
                String[] parts = headerStr.split(" ");
                String fileName = parts[0];
                int fileSize = Integer.parseInt(parts[1]);

                byte[] fileData = new byte[fileSize];
                instream.read(fileData);

                FileOutputStream outstream = new FileOutputStream(fileName);
                outstream.write(fileData);
                outstream.close();
            }

            instream.close();
            System.out.println("Unpacking completed.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}*/

/*import java.io.*;

public class MarvellousUnpacker {
    public MarvellousUnpacker(String packedFile) {
        unpackFile(packedFile);
    }

    public void unpackFile(String packedFile) {
        try {
            FileInputStream instream = new FileInputStream(packedFile);
            byte[] header = new byte[100];
            int bytesRead = 0;

            // Create a folder for unpacked files
            File outputDir = new File("UnpackedFiles");
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }

            while ((bytesRead = instream.read(header)) != -1) {
                String headerStr = new String(header).trim();
                String[] parts = headerStr.split(" ");
                String fileName = parts[0];
                int fileSize = Integer.parseInt(parts[1]);

                byte[] fileData = new byte[fileSize];
                instream.read(fileData);

                // Save inside UnpackedFiles folder
                FileOutputStream outstream = new FileOutputStream("UnpackedFiles/" + fileName);
                outstream.write(fileData);
                outstream.close();
            }

            instream.close();
            System.out.println("Unpacking completed.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}*/


import java.io.*;

public class MarvellousUnpacker {
    public MarvellousUnpacker(String packedFile) {
        unpackFile(packedFile);
    }

    public void unpackFile(String packedFile) {
        try {
            FileInputStream instream = new FileInputStream(packedFile);
            byte[] header = new byte[100];
            int bytesRead = 0;

            // Create UnpackedFiles folder inside frontend
            File outputDir = new File("UnpackedFiles");
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }

            while ((bytesRead = instream.read(header)) != -1) {
                String headerStr = new String(header).trim();
                String[] parts = headerStr.split(" ");
                String fullPath = parts[0];  // This is full path, we don't want to use it fully
                int fileSize = Integer.parseInt(parts[1]);

                // ✅ Get only file name from full path
                String fileName = new File(fullPath).getName();

                byte[] fileData = new byte[fileSize];
                instream.read(fileData);

                // Save the file inside UnpackedFiles folder
                FileOutputStream outstream = new FileOutputStream("UnpackedFiles/" + fileName);
                outstream.write(fileData);
                outstream.close();
            }

            instream.close();
            System.out.println("Unpacking completed.");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

