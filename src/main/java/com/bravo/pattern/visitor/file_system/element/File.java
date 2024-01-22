package com.bravo.pattern.visitor.file_system.element;

import com.bravo.pattern.visitor.file_system.visitor.FileSystemVisitor;
import lombok.Getter;

@Getter
public class File implements FileSystemElement {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}