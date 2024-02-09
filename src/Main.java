import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        State start = new State("s");
        State accept = new State("t");
        State reject = new State("r");

        State q_py0 = new State("q_py0");
        State q_py1 = new State("q_py1");

        State q1 = new State("q_1");
        State q0 = new State("q_0");
        State qb = new State("q_b");
        State qxhat = new State("q_xhat");

        State qy0 = new State("q_y0");
        State qy1 = new State("q_y1");

        // start transitions
        start.addTransition(new Transition(start, tapeSymbol.BLANK, accept, tapeSymbol.BLANK, 0));
        start.addTransition(new Transition(start, tapeSymbol.ZERO, q_py0, tapeSymbol.X_HAT, 1));
        start.addTransition(new Transition(start, tapeSymbol.ONE, q_py1, tapeSymbol.X_HAT, 1));

        // q_py0 transitions
        q_py0.addTransition(new Transition(q_py0, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        q_py0.addTransition(new Transition(q_py0, tapeSymbol.ZERO, q_py0, tapeSymbol.ZERO, 1));
        q_py0.addTransition(new Transition(q_py0, tapeSymbol.ZERO, qb, tapeSymbol.Y, -1));
        q_py0.addTransition(new Transition(q_py0, tapeSymbol.ONE, q_py0, tapeSymbol.ONE, 1));

        // q_py1 transitions
        q_py1.addTransition(new Transition(q_py1, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        q_py1.addTransition(new Transition(q_py1, tapeSymbol.ONE, q_py1, tapeSymbol.ONE, 1));
        q_py1.addTransition(new Transition(q_py1, tapeSymbol.ONE, qb, tapeSymbol.Y, -1));
        q_py1.addTransition(new Transition(q_py1, tapeSymbol.ZERO, q_py1, tapeSymbol.ZERO, 1));

        // qb transitions
        qb.addTransition(new Transition(qb, tapeSymbol.ZERO, qb, tapeSymbol.ZERO, -1));
        qb.addTransition(new Transition(qb, tapeSymbol.ONE, qb, tapeSymbol.ONE, -1));
        qb.addTransition(new Transition(qb, tapeSymbol.X, qb, tapeSymbol.X, -1));
        qb.addTransition(new Transition(qb, tapeSymbol.Y, qb, tapeSymbol.Y, -1));
        qb.addTransition(new Transition(qb, tapeSymbol.X_HAT, qxhat, tapeSymbol.X_HAT, 1));

        // qxhat transitions
        qxhat.addTransition(new Transition(qxhat, tapeSymbol.BLANK, accept, tapeSymbol.BLANK, 0));
        qxhat.addTransition(new Transition(qxhat, tapeSymbol.ZERO, q0, tapeSymbol.X, 1));
        qxhat.addTransition(new Transition(qxhat, tapeSymbol.ONE, q1, tapeSymbol.X, 1));
        qxhat.addTransition(new Transition(qxhat, tapeSymbol.Y, qxhat, tapeSymbol.Y, 1));
        qxhat.addTransition(new Transition(qxhat, tapeSymbol.X, qxhat, tapeSymbol.X, 1));

        // q0 transitions
        q0.addTransition(new Transition(q0, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        q0.addTransition(new Transition(q0, tapeSymbol.ZERO, q0, tapeSymbol.ZERO, 1));
        q0.addTransition(new Transition(q0, tapeSymbol.ONE, q0, tapeSymbol.ONE, 1));
        q0.addTransition(new Transition(q0, tapeSymbol.Y, qy0, tapeSymbol.Y, 1));

        // q1 transitions
        q1.addTransition(new Transition(q1, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        q1.addTransition(new Transition(q1, tapeSymbol.ONE, q1, tapeSymbol.ONE, 1));
        q1.addTransition(new Transition(q1, tapeSymbol.ZERO, q1, tapeSymbol.ZERO, 1));
        q1.addTransition(new Transition(q1, tapeSymbol.Y, qy1, tapeSymbol.Y, 1));

        // qy0 transitions
        qy0.addTransition(new Transition(qy0, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        qy0.addTransition(new Transition(qy0, tapeSymbol.ZERO, qb, tapeSymbol.Y, -1));
        qy0.addTransition(new Transition(qy0, tapeSymbol.ONE, reject, tapeSymbol.BLANK, 0));
        qy0.addTransition(new Transition(qy0, tapeSymbol.Y, qy0, tapeSymbol.Y, 1));

        // qy1 transitions
        qy1.addTransition(new Transition(qy1, tapeSymbol.BLANK, reject, tapeSymbol.BLANK, 0));
        qy1.addTransition(new Transition(qy1, tapeSymbol.ONE, qb, tapeSymbol.Y, -1));
        qy1.addTransition(new Transition(qy1, tapeSymbol.ZERO, reject, tapeSymbol.BLANK, 0));
        qy1.addTransition(new Transition(qy1, tapeSymbol.Y, qy1, tapeSymbol.Y, 1));





        Tape NTMTape = new Tape(new ArrayList<>(Arrays.asList(tapeSymbol.ONE, tapeSymbol.ZERO, tapeSymbol.ONE, tapeSymbol.ZERO, tapeSymbol.ONE, tapeSymbol.ZERO, tapeSymbol.ONE, tapeSymbol.ZERO)));

        Branch NTM = new Branch(NTMTape, start, 0);

        NTM.processBranch();
    }
}

