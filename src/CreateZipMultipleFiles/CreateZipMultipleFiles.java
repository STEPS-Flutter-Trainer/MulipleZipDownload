package CreateZipMultipleFiles;

import java.io.*;
import java.util.zip.*;

public class CreateZipMultipleFiles {

    public static void main(String args[]) {
        try {
            String zipFile = "file.zip";
            String[] sourceFiles = {
                    "Kumar1 20171102_191811.jpg",
                    "New Text Document.txt","sample.odt" };

            byte[] buffer = new byte[1024];

            FileOutputStream fout = new FileOutputStream(zipFile);

            ZipOutputStream zout = new ZipOutputStream(fout);

            for (int i = 0; i < sourceFiles.length; i++) {

                System.out.println("Adding " + sourceFiles[i]);

                FileInputStream fin = new FileInputStream(sourceFiles[i]);

                zout.putNextEntry(new ZipEntry(sourceFiles[i]));

                int length;

                while ((length = fin.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }

                zout.closeEntry();

                fin.close();

            }

            zout.close();

            System.out.println("Zip file has been created!");

        } catch (IOException ioe) {
            System.out.println("IOException :" + ioe);
        }

    }
}
