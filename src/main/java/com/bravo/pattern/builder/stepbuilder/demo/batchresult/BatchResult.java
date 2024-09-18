package com.bravo.pattern.builder.stepbuilder.demo.batchresult;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 批量操作通用结果
 */
@Getter
public class BatchResult<T> implements Serializable {
    private static final long serialVersionUID = -8832376158482051189L;

    private int totalCount;
    private int successCount;
    private int failureCount;
    private List<T> successItems;
    /**
     * 部分成功时的错误码及解释
     */
    private Integer failureCode;
    private String failureReason;

    /**
     * 是否全部成功
     */
    public boolean isAllCompleted() {
        return totalCount == successCount;
    }

    /**
     * 类型转换
     */
    public <R> BatchResult<R> convert(Function<T, R> converter) {
        return new BatchResult<>(
                totalCount,
                successCount,
                failureCount,
                successItems == null ? null : successItems.stream().map(converter).collect(Collectors.toList()),
                failureCode,
                failureReason
        );
    }


    // ----------------- 以下是builder -----------------

    private BatchResult() {
    }

    private BatchResult(int totalCount, int successCount, int failureCount, List<T> successItems, Integer failureCode, String failureReason) {
        this.totalCount = totalCount;
        this.successCount = successCount;
        this.failureCount = failureCount;
        this.successItems = successItems;
        this.failureCode = failureCode;
        this.failureReason = failureReason;
    }

    public static <T> InterruptedOrFinishedStep<T> builder() {
        return new Steps<>();
    }

    public static <T> InterruptedOrFinishedStep<T> builder(Class<T> itemType) {
        return new Steps<>();
    }

    public interface InterruptedOrFinishedStep<T> {
        ReasonStep<T> interrupted();

        FinishedResultStep<T> finished();
    }

    public interface ReasonStep<T> {
        InterruptedResultStep<T> reason(int code, String reason);

        InterruptedResultStep<T> reason(String reason);
    }

    public interface InterruptedResultStep<T> {
        ResultStep<T> result(int totalCount, int successCount);

        ResultStep<T> result(int totalCount, List<T> successItems);
    }

    public interface FinishedResultStep<T> {
        ResultStep<T> result(int totalCount, int successCount);

        ResultStep<T> result(int totalCount, List<T> successItems);
    }

    public interface ResultStep<T> {
        BatchResult<T> build();
    }

    private static class Steps<T> implements InterruptedOrFinishedStep<T>, ReasonStep<T>, InterruptedResultStep<T>, FinishedResultStep<T>, ResultStep<T> {
        private final BatchResult<T> batchResult = new BatchResult<>();

        @Override
        public ReasonStep<T> interrupted() {
            return this;
        }

        @Override
        public FinishedResultStep<T> finished() {
            return this;
        }

        @Override
        public InterruptedResultStep<T> reason(int code, String reason) {
            batchResult.failureCode = code;
            batchResult.failureReason = reason;
            return this;
        }

        @Override
        public InterruptedResultStep<T> reason(String reason) {
            batchResult.failureReason = reason;
            return this;
        }

        @Override
        public ResultStep<T> result(int totalCount, int successCount) {
            batchResult.totalCount = totalCount;
            batchResult.successCount = successCount;
            batchResult.failureCount = totalCount - successCount;
            return this;
        }

        @Override
        public ResultStep<T> result(int totalCount, List<T> successItems) {
            batchResult.totalCount = totalCount;
            batchResult.successItems = successItems;
            batchResult.successCount = successItems.size();
            batchResult.failureCount = totalCount - successItems.size();
            return this;
        }

        @Override
        public BatchResult<T> build() {
            return batchResult;
        }
    }
}
