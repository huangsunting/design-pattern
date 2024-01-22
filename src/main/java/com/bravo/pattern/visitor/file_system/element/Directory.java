package com.bravo.pattern.visitor.file_system.element;

import com.bravo.pattern.visitor.file_system.visitor.FileSystemVisitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        // 访问当前文件夹
        visitor.visit(this);
        // 访问当前文件夹下面的子文件
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}