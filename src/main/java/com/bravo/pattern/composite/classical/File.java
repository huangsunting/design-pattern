package com.bravo.pattern.composite.classical;

// 叶子节点类 - 文件
class File implements FileSystemComponent {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}