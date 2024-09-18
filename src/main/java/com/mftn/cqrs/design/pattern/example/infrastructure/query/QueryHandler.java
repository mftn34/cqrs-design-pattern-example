package com.mftn.cqrs.design.pattern.example.infrastructure.query;

public interface QueryHandler<TQuery extends Query, TResult> {
    TResult handle(TQuery query) throws Exception;
}