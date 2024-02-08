import java.util.List;

public class Tape {
    private final List<tapeSymbol> tape;
    private int headPosition;

    public Tape(List<tapeSymbol> tapeContents) {
        this.tape = tapeContents;
        this.headPosition = 0;
    }

    public void write(tapeSymbol symbol) {
        tape.set(headPosition, symbol);
    }

    public tapeSymbol read() {
        return tape.get(headPosition);
    }

    public void moveHead(int direction) {
        headPosition += direction;
        if (headPosition < 0) {
            headPosition = 0;
        } else if (headPosition >= tape.size()) {
            tape.add(tapeSymbol.BLANK);
        }
    }

    public String toString() {
        String tapeString = "|";
        for (int i = 0; i < tape.size(); i++) {
            if (i == headPosition) {
                tapeString += "[" + tape.get(i).toString() + "]|";
            } else {
                tapeString += tape.get(i).toString() + "|";
            }
        }
        return tapeString;
    }
}
