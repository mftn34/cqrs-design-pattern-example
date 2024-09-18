# CQRS Design Pattern Java 

<div align="center">

![1_n3zJulJ4aZA1_tVCjJ9SBw](https://user-images.githubusercontent.com/43035417/151057004-de91dfe4-2fcf-4573-9928-0ce7600992fe.png)

</div>


## Elasticsearch Index Creating And Mapping
We need create index on Elasticsearch because of representing database table on it. If you need checking Elasticsearch container status, you may use cURL code that is stay below.

```
curl -XGET "http://localhost:9200/_cat/health?format=json&pretty"
```

Create Index with mapping on Elasticsearch: 

```
curl --location --request PUT 'http://localhost:9200/classifieds' \
--header 'Content-Type: application/json' \
--data-raw '{
    "settings": {
        "index": {
            "number_of_shards": 1,
            "number_of_replicas": 1
        }
    },
    "mappings": {
        "properties": {
            "id": {
                "type": "long"
            },
            "title": {
                "type": "text"
            },
            "price": {
                "type": "double"
            },
            "detail": {
                "type": "text"
            },
            "categoryId": {
                "type": "long"
            }
        }
    }
}'
```

We will see mapping on Elasticsearch if there is no any error. We may use this cURL code that is below for showing mapping.
```
curl -XGET "http://localhost:9200/classifieds/_mapping?pretty&format=json"
```

It show use created index's mapping.

# Usages

Sending request to api then creating data on MySQL then sending RabbitMQ event that will update Elasticsearch:

```
curl --location --request POST 'http://localhost:8080/classifieds' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Macbook Pro 2019",
    "detail": "Sahibinden çok temiz Macbook Pro 2019.",
    "price": 27894,
    "categoryId": 47
}'
```

Reading classified list from Elasticsearch: 

```
curl --location --request GET 'http://localhost:8080/classifieds'
```

