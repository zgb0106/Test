package com.neuedu.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IOUtil {
    public static final String BASE_PATH = "db/";

    public static boolean append(String data,String tableName,boolean append) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(BASE_PATH + tableName,append);
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return true;
    }
}
