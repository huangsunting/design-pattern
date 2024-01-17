package com.bravo.pattern.composite.before;

import lombok.Data;

import java.util.List;

@Data
public class Box {
    // 包裹里还有小包裹，形成一种嵌套结构
    private List<Box> boxes;
    private List<Product> products;
}