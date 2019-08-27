package com.cn.ouyjs.io;

import java.io.*;

/**
 * @author ouyjs
 * @date 2019/7/5 10:40
 */
public class URLTest {
    public static void main(String[] args) {
        try {
            File file = new File("5日北京市场中厚板价格行情_我的钢铁.html");
           // URL url = new URL("https://zhongban.mysteel.com/m/19/0705/10/318A7443813C3A27.html");
            //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gb2312"));
            //BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "gb2312"));
           // BufferedWriter writer = new BufferedWriter(new FileWriter("text.html"));

            InputStreamReader in = new InputStreamReader(new FileInputStream(file),"gb2312");
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("text.html"),"utf-8");

            int len = in.read();
            while (-1!=len) {
                out.write(len);
                len = in.read();
            }
            out.flush();
            out.close();
            in.close();
           /* String line;
            while ((line = reader.readLine())!=null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.flush();
            writer.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
