package org.sheamus.java.io;

import java.io.*;

/**
 * 一个字节一个字节读取数据
 * Created by Sheamus on 2018/7/12.
 */
public class InputStreamByByte {
    public static void main(String[] args) {
        String path = "E:\\04-devFiles\\02-研究的技术\\学习视频教程.txt";
        File file = new File(path);
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            int len = inputStream.read(buffer);
            inputStream.close();
            System.out.println(new String(buffer,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bufferRead() throws Exception {
        String path = "E:\\04-devFiles\\02-研究的技术\\学习视频教程.txt";
        File file = new File(path);
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        int temp = 0;
        int len = 0;
        while ((temp = in.read()) != -1) {//-1为文件读完的标志
            b[len] = (byte) temp;
            len++;
        }
        in.close();
        System.out.println(new String(b, 0, len));
    }

}
