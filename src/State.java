import java.util.ArrayList;
import java.util.List;

public class State {
    String name;
    List<Transition> transitions;

    public State(String name) {
        this.name = name;
        this.transitions = new ArrayList<>();
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
