package com.mftn.cqrs.design.pattern.example.infrastructure.command.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandResult {
    private Boolean isSuccess;
    private String message;
}
