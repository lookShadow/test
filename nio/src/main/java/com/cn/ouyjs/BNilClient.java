package com.cn.ouyjs;

import java.io.IOException;

/**
 * @author ouyjs
 * @date 2019/8/21 12:08
 */
public class BNilClient {
    public static void main(String[] args) throws IOException {
        new NioClient().start();
    }
}
