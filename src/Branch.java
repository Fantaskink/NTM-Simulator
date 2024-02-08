import java.util.List;

public class Branch {
    private final Tape tape;
    private State currentState;

    public Branch(Tape tape, State currentState) {
        this.tape = tape;
        this.currentState = currentState;
    }

    public void setCurrentState(State nextState) {
        this.currentState = nextState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public Tape getTape() {
        return tape;
    }

    public void processBranch() {
        System.out.println("Tape contents:" + this.getTape().toString() + " Current state: " + this.getCurrentState().getName());
        for(Transition transition : this.getCurrentState().getTransitions()) {
            if (transition.getReadSymbol() == this.getTape().read()) {
                this.branch(transition);
            }
        }
    }

    public void branch(Transition transition) {
        Branch nextBranch = new Branch(this.getTape(), this.getCurrentState());
        nextBranch.getTape().write(transition.getWriteSymbol());
        nextBranch.getTape().moveHead(transition.getHeadDirection());
        nextBranch.setCurrentState(transition.getDestination());
        nextBranch.processBranch();
    }

}
