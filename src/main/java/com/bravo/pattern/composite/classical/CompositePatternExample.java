package com.bravo.pattern.composite.classical;

public class CompositePatternExample {
    public static void main(String[] args) {
        // 创建文件和目录组合
        File file1 = new File("File 1");
        File file2 = new File("File 2");

        Directory dir1 = new Directory("Directory 1");
        File file3 = new File("File 3");
        File file4 = new File("File 4");

        Directory dir2 = new Directory("Directory 2");
        File file5 = new File("File 5");

        // 构建组合结构
        dir1.add(file3);
        dir1.add(file4);

        dir2.add(file5);

        // 构建整体文件系统
        Directory fileSystem = new Directory("File System");
        fileSystem.add(file1);
        fileSystem.add(file2);
        fileSystem.add(dir1);
        fileSystem.add(dir2);

        // 显示整体文件系统
        fileSystem.display();
    }
}