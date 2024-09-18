package com.mftn.cqrs.design.pattern.example.infrastructure.command;

import com.mftn.cqrs.design.pattern.example.infrastructure.command.result.CommandResult;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface CommandHandler<TCommand extends Command> {
    CommandResult handle(TCommand command) throws IOException, TimeoutException;
}
