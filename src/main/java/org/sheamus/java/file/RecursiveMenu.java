package org.sheamus.java.file;

import java.io.File;

/**
 * Created by Sheamus on 2018/7/17.
 */
public class RecursiveMenu {
    public void recursiveFile(File file,int level) {
        if(file == null) {
            return;
        }

        if(level == 0) {
            System.out.println("" + file.getName());
        } else {
            for(int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(" |- " + file.getName());
        }

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for (File newFile : files) {
                    recursiveFile(newFile,level + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        RecursiveMenu menu = new RecursiveMenu();
        menu.recursiveFile(new File("E:\\04-devFiles\\02-研究的技术"),0);
    }
}
