package com.bravo.pattern.visitor.file_system;

import com.bravo.pattern.visitor.file_system.element.Directory;
import com.bravo.pattern.visitor.file_system.element.File;
import com.bravo.pattern.visitor.file_system.visitor.CalculateSizeVisitor;

public class FileTest {

    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 20);

        documents.addElement(file1);
        documents.addElement(file2);
        root.addElement(documents);

        CalculateSizeVisitor sizeVisitor = new CalculateSizeVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize());
    }

}