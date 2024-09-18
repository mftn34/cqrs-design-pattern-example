package com.mftn.cqrs.design.pattern.example.infrastructure.query.impl.classified;

import com.mftn.cqrs.design.pattern.example.infrastructure.query.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GetClassifiedsQuery implements Query {
    private String price;
    private String categoryId;
}
