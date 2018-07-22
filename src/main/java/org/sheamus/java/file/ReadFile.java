package org.sheamus.java.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class ReadFile {

    public static void readFile(File file) {
        List<File> list = new ArrayList<File>();
        list.add(file);
        for (int i = 0; i < list.size(); ) {
            if (list.get(i).isDirectory()) {
                File[] tempList = list.get(i).listFiles();
                for (int j = 0; j < tempList.length; j++) {
                    list.add(tempList[j]);
                }
            }
            System.out.println(list.get(i).getName());
            list.remove(i);
        }
    }

    public static void main(String[] args) {
        File fiel = new File("E:\\04-devFiles\\02-研究的技术");
        readFile(fiel);
    }
}
