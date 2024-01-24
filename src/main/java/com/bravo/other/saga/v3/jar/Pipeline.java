package com.bravo.other.saga.v3.jar;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pipeline<I, O, C> {
    private I request;

    private O response;

    private C context;
}