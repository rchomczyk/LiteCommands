package dev.rollczi.litecommands.argument.simple;

import dev.rollczi.litecommands.command.sugesstion.Suggestion;
import dev.rollczi.litecommands.command.LiteInvocation;
import panda.std.Result;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
public interface OneArgument<T> extends MultilevelArgument<T> {

    @Override
    default Result<T, ?> parseMultilevel(LiteInvocation invocation, String... arguments) {
        if (arguments.length != 1) {
            throw new IllegalArgumentException();
        }

        return parse(invocation, arguments[0]);
    }

    Result<T, ?> parse(LiteInvocation invocation, String argument);

    default List<Suggestion> suggest(LiteInvocation invocation) {
        return Collections.emptyList();
    }

    @Override
    default int countMultilevel() {
        return 1;
    }

    static <T> OneArgument<T> create(BiFunction<LiteInvocation, String, Result<T, ?>> parse, Function<LiteInvocation, List<Suggestion>> suggest) {
        return new SuggestedOneArgument<>(parse, suggest);
    }

}
