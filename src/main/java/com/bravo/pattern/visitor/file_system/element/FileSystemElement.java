package com.bravo.pattern.visitor.file_system.element;

import com.bravo.pattern.visitor.file_system.visitor.FileSystemVisitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
