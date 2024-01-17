package com.bravo.pattern.iterator.iterator;

public interface Iterable<T> {

    // 子类必须返回一个迭代器，让客户程序方便地遍历
    Iterator<T> iterator();
}