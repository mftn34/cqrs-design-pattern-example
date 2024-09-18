package com.mftn.cqrs.design.pattern.example.elastic.service;

import java.io.IOException;
import java.util.List;

public interface ElasticsearchService {
    <TSource extends Object> void insertDocument(String indexName, String documentUniqueId, TSource source) throws IOException;

    <TSource> List<TSource> search(String indexName, Class<TSource> clazz) throws IOException, Exception;
}
