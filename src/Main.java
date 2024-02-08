import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<State> states = new ArrayList<>();

        State start = new State("q_s");
        State accept = new State("t");
        State reject = new State("r");

        start.addTransition(new Transition(start, tapeSymbol.ZERO, start, tapeSymbol.X, 1));
        start.addTransition(new Transition(start, tapeSymbol.ZERO, start, tapeSymbol.ZERO, 1));
        start.addTransition(new Transition(start, tapeSymbol.ONE, start, tapeSymbol.ONE, 1));
        start.addTransition(new Transition(start, tapeSymbol.BLANK, accept, tapeSymbol.BLANK, 1));

        Branch NTM = new Branch(new Tape(new ArrayList<tapeSymbol>(Arrays.asList(tapeSymbol.ZERO,tapeSymbol.ZERO,tapeSymbol.ONE))), start);

        NTM.processBranch();

        /*
        State start = new State("q_s");
        State accept = new State("t");
        State reject = new State("r");
        State q1 = new State("q_1");
        State q0 = new State("q_0");

        // start transitions
        start.addTransition(new Transition(start, tapeSymbol.BLANK, accept, tapeSymbol.BLANK, 0));
        start.addTransition(new Transition(start, tapeSymbol.ZERO, q0, tapeSymbol.X_HAT, 1));
        start.addTransition(new Transition(start, tapeSymbol.ONE, q1, tapeSymbol.X_HAT, 1));

        q0.addTransition(new Transition(q0, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        q0.addTransition(new Transition(q0, ));
        */


    }
}

