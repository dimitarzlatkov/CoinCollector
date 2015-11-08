package com.dimitar.zlatkov.eurocoincollector.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.Log;

/**
 * Utility methods for parsing streams.
 *
 * @author dimitar.zlatkov
 */
public class IOHelper {
    public static final String LOG_TAG = "IOHelper";

    /**
     * Reads the contents of the file pointed to by the given file path to string.
     *
     * @param filePath The path to the file which to read.
     * @return The string content of the file.
     */
    public static String readFileAsString(String filePath) {
        String fileContent = null;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            fileContent = parseStream(fis);
        } catch (FileNotFoundException e) {
            Log.w(LOG_TAG, e);
        }
        return fileContent;
    }

    /**
     * Returns the content of the given asset file.
     *
     * @param assets The assets from which to fetch the file.
     * @param fileName The name of the file for which to fetch the content.
     * @return The content or null if an error occurred while accessing.
     */
    public static String getFileContent(Resources resources, String fileName, Context context) {
        String content = null;
        try {
            int identifier = resources.getIdentifier(fileName, "raw", context.getPackageName());
            InputStream inputStream = resources.openRawResource(identifier);
            content = parseStream(inputStream);
        } catch (NotFoundException e) {
            Log.e(LOG_TAG, "Missing file " + fileName, e);
        }
        return content;
    }

    /**
     * Parses an InputStream to a String.
     *
     * @param inputStream The stream to be parsed.
     * @return The stream content as string.
     */
    public static String parseStream(InputStream inputStream) {
        String content = null;
        try {
            int BUFFER_SIZE = 1024;
            byte[] buffer = new byte[BUFFER_SIZE];
            StringBuilder builder = new StringBuilder();
            int count;
            while ((count = inputStream.read(buffer, 0, BUFFER_SIZE)) != -1) {
                builder.append(new String(buffer, 0, count));
            }
            content = builder.toString();
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error while reading input stream", e);
        }
        return content;
    }



}