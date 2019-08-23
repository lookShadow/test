package com.cn.ouyjs.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author ouyjs
 * @date 2019/8/22 10:09
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        new FileTest().writeFile();
        new FileTest().readFile();
    }

    public void readFile() throws IOException {
        File file = new File("C:\\me\\project\\test\\src\\file.text");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line = reader.readLine())!=null) {
            System.out.println(line);
        }
        reader.close();
    }

    public void writeFile() throws IOException {
        File file = new File("C:\\me\\project\\test\\src\\file.text");
        boolean exists = file.exists();
        if (!exists) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        writer.write("asdqwed\nasdqwas\n");
        writer.flush();
    }
}
