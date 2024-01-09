package com.bravo.advanced.fluent.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 惰性执行的流：通过addOperation保存每一步操作，直到调用终端操作（toList等）
 */
public class LazyFluentStream<T> implements FluentStream<T> { // 装饰者模式

    private final FluentStream<T> fluentStream;
    private final List<Function<FluentStream<T>, FluentStream<T>>> operations;

    LazyFluentStream(FluentStream<T> fluentStream, List<Function<FluentStream<T>, FluentStream<T>>> operations) {
        this.fluentStream = fluentStream;
        this.operations = operations;
    }

    public static <T> FluentStream<T> from(List<T> data) {
        // LazyFluentStream内部持有NormalFluentStream，并对其增强：惰性执行
        return new LazyFluentStream<>(new NormalFluentStream<>(data), new ArrayList<>());
    }

    @Override
    public FluentStream<T> filter(Predicate<? super T> predicate) {
        // filter这一步操作的本质就是：上游函数产生了一个stream，它拿着这个stream+predicate，产生新的stream返回
        return addOperation(stream -> stream.filter(predicate));
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <R> FluentStream<R> map(Function<? super T, ? extends R> mapper) {
        return (FluentStream<R>) addOperation(stream -> (FluentStream<T>) stream.map(mapper));
    }

    @Override
    public FluentStream<T> sorted(Comparator<? super T> comparator) {
        return addOperation(stream -> stream.sorted(comparator));
    }

    @Override
    public FluentStream<T> distinct() {
        return addOperation(stream -> stream.distinct());
    }

    @Override
    public FluentStream<T> peek(Consumer<? super T> action) {
        return addOperation(stream -> stream.peek(action));
    }

    @Override
    public Optional<T> first() {
        return fluentStream.first();
    }

    @Override
    public FluentStream<T> first(int count) {
        return addOperation(stream -> stream.first(count));
    }

    @Override
    public Optional<T> last() {
        return fluentStream.last();
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return fluentStream.reduce(accumulator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return fluentStream.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return fluentStream.max(comparator);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return fluentStream.min(comparator);
    }

    @Override
    public long count() {
        return fluentStream.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return fluentStream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return fluentStream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return fluentStream.noneMatch(predicate);
    }

    @Override
    public FluentStream<T> last(int count) {
        return addOperation(stream -> stream.last(count));
    }

    @Override
    public List<T> toList() {
        // 对当前stream按顺序执行缓存起来的operation，每一步operation输出的stream作为下一步的输入
        FluentStream<T> stream = fluentStream;
        for (Function<FluentStream<T>, FluentStream<T>> operation : operations) {
            stream = operation.apply(stream);
        }
        // 执行结束，获取list
        return stream.toList();
    }

    @Override
    public <K, R> Map<K, R> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends R> valueMapper) {
        Map<K, R> resultMap = new HashMap<>();
        for (T item : toList()) {
            resultMap.put(keyMapper.apply(item), valueMapper.apply(item));
        }
        return resultMap;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        toList().forEach(action);
    }

    private FluentStream<T> addOperation(Function<FluentStream<T>, FluentStream<T>> operation) {
        operations.add(operation);
        return new LazyFluentStream<>(fluentStream, operations);
    }
}