package com.bravo.advanced.fluent.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NormalFluentStream<T> implements FluentStream<T> {

    private final List<T> data;

    NormalFluentStream(List<T> data) {
        this.data = data;
    }

    public static <T> FluentStream<T> from(List<T> data) {
        return new NormalFluentStream<>(data);
    }

    @Override
    public FluentStream<T> filter(Predicate<? super T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                filteredData.add(item);
            }
        }
        return new NormalFluentStream<>(filteredData);
    }

    @Override
    public <R> FluentStream<R> map(Function<? super T, ? extends R> mapper) {
        List<R> mappedData = new ArrayList<>();
        for (T item : data) {
            mappedData.add(mapper.apply(item));
        }
        return new NormalFluentStream<>(mappedData);
    }

    @Override
    public FluentStream<T> sorted(Comparator<? super T> comparator) {
        // 不要直接对源数据排序，这样会修改源数据
        ArrayList<T> newData = new ArrayList<>(data);
        newData.sort(comparator);
        return new NormalFluentStream<>(newData);
    }

    @Override
    public FluentStream<T> distinct() {
        return new NormalFluentStream<>(new ArrayList<>(new LinkedHashSet<>(data)));
    }

    @Override
    public FluentStream<T> peek(Consumer<? super T> action) {
        List<T> peekedData = new ArrayList<>();
        for (T item : data) {
            action.accept(item);
            peekedData.add(item);
        }
        return new NormalFluentStream<>(peekedData);
    }

    @Override
    public Optional<T> first() {
        return data.isEmpty() ? Optional.empty() : Optional.of(data.get(0));
    }

    @Override
    public FluentStream<T> first(int count) {
        List<T> headElements = data.subList(0, Math.min(count, data.size()));
        return new NormalFluentStream<>(headElements);
    }

    @Override
    public Optional<T> last() {
        return data.isEmpty() ? Optional.empty() : Optional.of(data.get(data.size() - 1));
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        if (data.isEmpty()) {
            return Optional.empty();
        }

        T result = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            result = accumulator.apply(result, data.get(i));
        }
        return Optional.of(result);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        for (T item : data) {
            result = accumulator.apply(result, item);
        }
        return result;
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        if (data.isEmpty()) {
            return Optional.empty();
        }

        T maxElement = data.get(0);
        for (T item : data) {
            if (comparator.compare(item, maxElement) > 0) {
                maxElement = item;
            }
        }
        return Optional.of(maxElement);
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        if (data.isEmpty()) {
            return Optional.empty();
        }

        T minElement = data.get(0);
        for (T item : data) {
            if (comparator.compare(item, minElement) < 0) {
                minElement = item;
            }
        }
        return Optional.of(minElement);
    }

    @Override
    public long count() {
        return data.size();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        for (T item : data) {
            if (predicate.test(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        for (T item : data) {
            if (!predicate.test(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        for (T item : data) {
            if (predicate.test(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public FluentStream<T> last(int count) {
        int startIndex = Math.max(0, data.size() - count);
        List<T> tailElements = data.subList(startIndex, data.size());
        return new NormalFluentStream<>(tailElements);
    }

    @Override
    public List<T> toList() {
        return data;
    }

    @Override
    public <K, R> Map<K, R> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends R> valueMapper) {
        Map<K, R> resultMap = new HashMap<>();
        for (T item : data) {
            resultMap.put(keyMapper.apply(item), valueMapper.apply(item));
        }
        return resultMap;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T item : data) {
            action.accept(item);
        }
    }
}
