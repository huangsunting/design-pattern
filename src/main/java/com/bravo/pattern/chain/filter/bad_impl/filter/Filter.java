package com.bravo.pattern.chain.filter.bad_impl.filter;

import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;

public interface Filter {

    boolean doFilter(Request req, Response res);

    void setNext(Filter filter);

    Filter getNext();
}