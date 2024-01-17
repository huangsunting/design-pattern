package com.bravo.pattern.composite.classical;

import java.util.ArrayList;
import java.util.List;

// 组合类 - 目录
class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    // 添加子组件（叶子节点或其他组合对象）
    public void add(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        // 递归显示所有子组件
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}
