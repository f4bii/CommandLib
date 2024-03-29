package de.f4bii.commandlib;

import de.f4bii.commandlib.parser.AdapterWrapper;
import de.f4bii.commandlib.parser.CommandParser;

public class SubCommandArgument<T> {

    private final CommandParser<?> parser;
    private final int argPosition;
    private final int mappedPosition;

    public SubCommandArgument(Class<T> type, int argPosition, int mappedPosition) {
        this.argPosition = argPosition;
        this.mappedPosition = mappedPosition;
        this.parser = AdapterWrapper.getParser(type);
    }

    public void injectValue(String[] args, Object[] mapped) {
        if (parser == null) {
            mapped[mappedPosition] = args[argPosition];
            return;
        }
        mapped[mappedPosition] = parser.parse(args[argPosition]);
    }
}
