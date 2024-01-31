package com.bravo.pattern.visitor.walk_file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * NIO包对于Visitor Pattern的应用（非标准）
 */
public class WalkFileTest {

    public static void main(String[] args) throws IOException {
        String path = "/Users/bravo1988/IdeaProjects/design_pattern/src/main/java/com/bravo/pattern/visitor/double_dispatch";
        Files.walkFileTree(Paths.get(path), new FileNamePrintVisitor());
    }

    static class FileNamePrintVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.TERMINATE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}
