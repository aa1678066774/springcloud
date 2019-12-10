package com.tww.nio.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-10 15:04
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Administrator\\Desktop\\nio\\a.txt");

        boolean pathExists = Files.exists(path,new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        System.out.println(pathExists);

        Path path1 = Paths.get("C:\\Users\\Administrator\\Desktop\\nio\\test\\a.txt");

//        Files.createDirectory(path1);

//        Files.copy(path,path1);


        Path path2 = Paths.get("C:\\Users\\Administrator\\Desktop\\nio");
        Files.walkFileTree(path2, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("pre visit dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visit file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("post visit directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
