package com.bravo.advanced.fluent.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FluentStream<T> {

    FluentStream<T> filter(Predicate<? super T> predicate);

    <R> FluentStream<R> map(Function<? super T, ? extends R> mapper);

    FluentStream<T> sorted(Comparator<? super T> comparator);

    FluentStream<T> distinct();

    FluentStream<T> peek(Consumer<? super T> action);

    FluentStream<T> first(int count);

    FluentStream<T> last(int count);

    Optional<T> first();

    Optional<T> last();

    Optional<T> reduce(BinaryOperator<T> accumulator);

    T reduce(T identity, BinaryOperator<T> accumulator);

    Optional<T> max(Comparator<? super T> comparator);

    Optional<T> min(Comparator<? super T> comparator);

    long count();

    boolean anyMatch(Predicate<? super T> predicate);

    boolean allMatch(Predicate<? super T> predicate);

    boolean noneMatch(Predicate<? super T> predicate);

    List<T> toList();

    <K, R> Map<K, R> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends R> valueMapper);

    void forEach(Consumer<? super T> action);
}
