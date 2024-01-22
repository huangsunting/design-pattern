package com.bravo.pattern.visitor.file_system.visitor;


import com.bravo.pattern.visitor.file_system.element.Directory;
import com.bravo.pattern.visitor.file_system.element.File;

public interface FileSystemVisitor {

    void visit(File file);

    void visit(Directory directory);
}
