package com.mftn.cqrs.design.pattern.example.controller;

import com.mftn.cqrs.design.pattern.example.infrastructure.command.impl.classified.CreateClassifiedCommand;
import com.mftn.cqrs.design.pattern.example.infrastructure.command.impl.classified.CreateClassifiedCommandHandler;
import com.mftn.cqrs.design.pattern.example.infrastructure.command.result.CommandResult;
import com.mftn.cqrs.design.pattern.example.infrastructure.query.impl.classified.GetClassifiedsQuery;
import com.mftn.cqrs.design.pattern.example.infrastructure.query.impl.classified.GetClassifiedsQueryHandler;
import com.mftn.cqrs.design.pattern.example.entity.Classified;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/classifieds")
public class ClassifiedController {

    private final GetClassifiedsQueryHandler getClassifiedsQueryHandler;
    private final CreateClassifiedCommandHandler createClassifiedCommandHandler;

    public ClassifiedController(GetClassifiedsQueryHandler getClassifiedsQueryHandler, CreateClassifiedCommandHandler createClassifiedCommandHandler) {
        this.getClassifiedsQueryHandler = getClassifiedsQueryHandler;
        this.createClassifiedCommandHandler = createClassifiedCommandHandler;
    }

    @GetMapping
    public ResponseEntity<?> index() throws Exception {
        List<Classified> classifieds = this.getClassifiedsQueryHandler.handle(new GetClassifiedsQuery());
        return ResponseEntity.ok(classifieds);
    }

    @PostMapping
    public CommandResult add(@RequestBody CreateClassifiedCommand command) throws IOException, TimeoutException {
        return this.createClassifiedCommandHandler.handle(command);
    }
}