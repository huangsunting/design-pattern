package com.bravo.pattern.visitor.file_system.visitor;

import com.bravo.pattern.visitor.file_system.element.Directory;
import com.bravo.pattern.visitor.file_system.element.File;
import lombok.Getter;

@Getter
public class CalculateSizeVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        // 统计文件大小
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // 文件夹，不需要统计
    }
}