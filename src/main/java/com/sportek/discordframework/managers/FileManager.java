package com.sportek.discordframework.managers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileManager {

    public void copyFileFromRessource(InputStream inputStream, File file) throws Exception {
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
}
