public class Branch {
    private final Tape tape;
    private final State currentState;
    private final int depth;

    public Branch(Tape tape, State currentState, int depth) {
        this.tape = new Tape(tape);
        this.currentState = new State(currentState);
        this.depth = depth;
    }

    public State getCurrentState() {
        return currentState;
    }

    public Tape getTape() {
        return tape;
    }

    public int getDepth() {
        return depth;
    }

    public void processBranch() {
        System.out.println(getIndentString() + "Tape contents:" + this.getTape().toString() + " Current state: " + this.getCurrentState().getName());
        if (this.getCurrentState().getName() == "t") {
            System.out.println(getIndentString() + "Branch accepted\n");
            return;
        }

        if (this.getCurrentState().getName() == "r") {
            System.out.println(getIndentString() + "Branch rejected\n");
            return;
        }


        for(Transition transition : this.getCurrentState().getTransitions()) {
            int addDepth;
            if (this.getValidTransitionCount() > 1) {
                addDepth = 1;
            } else {
                addDepth = 0;
            }
            if (transition.readSymbol() == this.getTape().read()) {
                this.branch(transition, addDepth);
            }
        }
    }

    public void branch(Transition transition, int addDepth) {
        Branch nextBranch = new Branch(this.getTape(), transition.destination(), this.getDepth() + addDepth);
        nextBranch.getTape().write(transition.writeSymbol());
        nextBranch.getTape().moveHead(transition.headDirection());
        nextBranch.processBranch();
    }

    public int getValidTransitionCount() {
        int count = 0;
        for(Transition transition : this.getCurrentState().getTransitions()) {
            if (transition.readSymbol() == this.getTape().read()) {
                count++;
            }
        }
        return count;
    }

    private String getIndentString() {
        return "  ".repeat(Math.max(0, this.getDepth()));
    }

}
