package com.bravo.pattern.builder.stepbuilder.demo.batchresult_v2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 批量操作通用结果V2
 */
@Getter
public class BatchResult<T> implements Serializable {
    private static final long serialVersionUID = -8832376158482051189L;

    private Data<T> data;
    private Integer errorCode;
    private String errorMsg;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data<T> {
        private int totalCount;
        private int successCount;
        private int failureCount;
        private List<T> successItems;
        private Integer interruptedCode;
        private String interruptedMsg;

        /**
         * 是否全部成功
         */
        public boolean isAllCompleted() {
            return totalCount == successCount;
        }
    }

    /**
     * 调用结果
     */
    public boolean isSuccess() {
        return errorCode == null;
    }

    /**
     * 类型转换
     */
    public <R> BatchResult<R> convert(Function<T, R> converter) {
        return new BatchResult<>(
                data == null ?
                        null :
                        new Data<>(
                                data.totalCount,
                                data.successCount,
                                data.failureCount,
                                data.successItems == null ?
                                        null :
                                        data.successItems.stream().map(converter).collect(Collectors.toList()),
                                data.interruptedCode,
                                data.interruptedMsg
                        ),
                errorCode,
                errorMsg
        );
    }

    public static <T> BatchResult<T> failed(String errorMsg) {
        return failed(-1, errorMsg);
    }

    public static <T> BatchResult<T> failed(Integer errorCode, String errorMsg) {
        return new BatchResult<>(
                null,
                errorCode,
                errorMsg
        );
    }

    public static <T> ReasonStep<T> interrupted(Class<T> itemType) {
        return new Steps<>();
    }

    public static <T> FinishedResultStep<T> finished(Class<T> itemType) {
        return new Steps<>();
    }

    // ----------------- 以下是builder -----------------

    private BatchResult() {
    }

    private BatchResult(Data<T> data, Integer errorCode, String errorMsg) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public interface ReasonStep<T> {
        InterruptedResultStep<T> reason(Integer interruptedCode, String interruptedMsg);

        InterruptedResultStep<T> reason(String interruptedMsg);
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
        BatchResult<T> end();
    }

    private static class Steps<T> implements ReasonStep<T>, InterruptedResultStep<T>, FinishedResultStep<T>, ResultStep<T> {
        private final Data<T> data = new Data<>();

        @Override
        public InterruptedResultStep<T> reason(Integer interruptedCode, String interruptedMsg) {
            data.interruptedCode = interruptedCode;
            data.interruptedMsg = interruptedMsg;
            return this;
        }

        @Override
        public InterruptedResultStep<T> reason(String interruptedMsg) {
            data.interruptedMsg = interruptedMsg;
            return this;
        }

        @Override
        public ResultStep<T> result(int totalCount, int successCount) {
            data.totalCount = totalCount;
            data.successCount = successCount;
            data.failureCount = totalCount - successCount;
            return this;
        }

        @Override
        public ResultStep<T> result(int totalCount, List<T> successItems) {
            data.totalCount = totalCount;
            data.successItems = successItems;
            data.successCount = successItems.size();
            data.failureCount = totalCount - successItems.size();
            return this;
        }

        @Override
        public BatchResult<T> end() {
            return new BatchResult<>(data, null, null);
        }
    }
}