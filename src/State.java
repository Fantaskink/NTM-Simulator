import java.util.ArrayList;
import java.util.List;

public class State {
    private final String name;
    private final List<Transition> transitions = new ArrayList<>();

    public State(String name) {
        this.name = name;
    }

    public State(State state) {
        this.name = state.name;
        this.transitions.addAll(state.transitions);
    }

    public String getName() {
        return name;
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
