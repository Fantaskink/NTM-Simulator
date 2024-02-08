public class Transition {
    private final State source;
    private final State destination;
    private final tapeSymbol readSymbol;
    private final tapeSymbol writeSymbol;
    private final int headDirection;

    public Transition(State source, tapeSymbol readSymbol, State destination, tapeSymbol writeSymbol, int headDirection) {
        this.source = source;
        this.readSymbol = readSymbol;
        this.destination = destination;
        this.writeSymbol = writeSymbol;
        this.headDirection = headDirection;
    }

    public State getSource() {
        return source;
    }

    public State getDestination() {
        return destination;
    }

    public tapeSymbol getReadSymbol() {
        return readSymbol;
    }

    public tapeSymbol getWriteSymbol() {
        return writeSymbol;
    }

    public int getHeadDirection() {
        return headDirection;
    }


}

