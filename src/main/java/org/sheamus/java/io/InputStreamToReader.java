package org.sheamus.java.io;

import java.io.*;

/**
 * 字节流转换成字符流
 * Created by Sheamus on 2018/7/11.
 */
public class InputStreamToReader {

    public static void main(String[] args) {
        String path = "E:\\04-devFiles\\02-研究的技术\\学习视频教程.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            // 将字节流转换成字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String data = null;
            while((data = reader.readLine()) != null) {
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
