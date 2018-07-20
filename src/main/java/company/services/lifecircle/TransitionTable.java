package company.services.lifecircle;

import javafx.util.Pair;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransitionTable {
    Set<Pair<State, State>> transitions = new HashSet<>();

    private static TransitionTable ourInstance = new TransitionTable();

    public static TransitionTable getInstance() {
        return ourInstance;
    }

    private TransitionTable() {
        init();
    }

    private void init(){
        transitions.add(new Pair<>(State.REGISTERED, State.IN_PROGRESS));
        transitions.add(new Pair<>(State.IN_PROGRESS, State.MANUAL_TESTING));
        transitions.add(new Pair<>(State.IN_PROGRESS, State.SYSTEM_TESTING));
        transitions.add(new Pair<>(State.IN_PROGRESS, State.DONE));
        transitions.add(new Pair<>(State.SYSTEM_TESTING, State.DONE));
        transitions.add(new Pair<>(State.MANUAL_TESTING, State.IN_PROGRESS));
        transitions.add(new Pair<>(State.SYSTEM_TESTING, State.IN_PROGRESS));
    }

    public boolean isCorrectTransition(State from, State to){
        Pair<State,State> transition = new Pair<>(from,to);
        return transitions.contains(transition);
    }
}
