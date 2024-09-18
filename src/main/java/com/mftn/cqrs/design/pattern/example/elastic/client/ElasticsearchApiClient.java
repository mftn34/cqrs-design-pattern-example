package com.mftn.cqrs.design.pattern.example.elastic.client;

import org.elasticsearch.client.RestHighLevelClient;

public interface ElasticsearchApiClient {

    RestHighLevelClient getRestHighLevelClient();
}