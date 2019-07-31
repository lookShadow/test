package com.cn.ouyjs.myProject;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author ouyjs
 * @date 2019/6/20 15:27
 */
public class FileTest {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        File file = new File(path+"\\"+"index.text");
        File file1 = new File(path+"\\"+"demo.text");
        byte[] bytes = new byte[1024];
        try {
            FileInputStream in = new FileInputStream(file);
            FileOutputStream out = new FileOutputStream(file1);
            int len;
            while ((len = in.read(bytes)) > 0) {
                System.out.println(len);
                out.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这应该就是你代码在什么机器上跑的，就是返回该机器的系统名称。
     * @return
     */
    public static String getLinkFilePath() {
        String name = System.getProperty("os.name").toLowerCase();
        System.out.println(name);
        String shortPath = "\\";
        if (StringUtils.equals(name,"windows")) {
            shortPath = "/";
        }
        return shortPath;
    }
}
