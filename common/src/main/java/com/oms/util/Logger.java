package com.oms.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private String path;
    private FileOutputStream os;

    public void setPath(String path) {
        this.path = path;
    }

    public void log(String msg) {
        try {
            if (os == null) {
                if (path == null) {
                    //tests
                    return;
                }
                os = new FileOutputStream(path, true);
            }
            PrintWriter pw = new PrintWriter(os);
            pw.println(msg);
            pw.flush();
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
