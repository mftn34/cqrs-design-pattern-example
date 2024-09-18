package com.mftn.cqrs.design.pattern.example.repository;

import com.mftn.cqrs.design.pattern.example.entity.Classified;
import org.springframework.data.repository.CrudRepository;

public interface ClassifiedRepository extends CrudRepository<Classified, Long> {
}
