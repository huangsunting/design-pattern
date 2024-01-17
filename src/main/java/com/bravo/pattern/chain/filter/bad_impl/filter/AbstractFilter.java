package com.bravo.pattern.chain.filter.bad_impl.filter;


import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;

public abstract class AbstractFilter implements Filter {

    // 每一个Filter内部持有下一个Filter的引用
    private Filter nextFilter;

    @Override
    public boolean doFilter(Request req, Response res) {
        return this.judge(req, res) ? this.next(req, res) : this.stop();
    }

    // 抽象方法，留给子类实现（实际的校验逻辑）
    protected abstract boolean judge(Request req, Response res);

    private boolean next(Request req, Response res) {
        return nextFilter != null && nextFilter.doFilter(req, res);
    }

    private boolean stop() {
        return false;
    }

    @Override
    public void setNext(Filter filter) {
        this.nextFilter = filter;
    }

    @Override
    public Filter getNext() {
        return this.nextFilter;
    }
}