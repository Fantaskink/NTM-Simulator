public record Transition(State source, tapeSymbol readSymbol, State destination, tapeSymbol writeSymbol, int headDirection) {}

