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
            System.out.println(getIndentString() + "Branch accepted");
            return;
        }

        if (this.getCurrentState().getName() == "r") {
            System.out.println(getIndentString() + "Branch rejected");
            return;
        }

        //System.out.println(this.getCurrentState().getTransitions().size());
        for(Transition transition : this.getCurrentState().getTransitions()) {
            if (transition.readSymbol() == this.getTape().read()) {
                this.branch(transition);
            }
        }
    }

    public void branch(Transition transition) {
        Branch nextBranch = new Branch(this.getTape(), transition.destination(), this.getDepth() + 1);
        nextBranch.getTape().write(transition.writeSymbol());
        nextBranch.getTape().moveHead(transition.headDirection());
        nextBranch.processBranch();
    }

    private String getIndentString() {
        return "  ".repeat(Math.max(0, this.getDepth()));
    }

}
