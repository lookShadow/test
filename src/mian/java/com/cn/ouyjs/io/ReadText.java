package com.cn.ouyjs.io;

import java.io.*;

/**
 * @author ouyjs
 * @date 2019/6/12 17:11
 */
public class ReadText {

    public static void main(String[] args) {
        writeFile();
        readFile();
    }

    public static void readFile(){
        try {
            FileReader fileReader = new FileReader("index.text");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        try {
            File file = new File("index.text");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("asd"+"\n");
            bufferedWriter.write("asdqwe");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
