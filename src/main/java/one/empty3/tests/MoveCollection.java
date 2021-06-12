package one.empty3.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MoveCollection {
    private HashMap<String, Move> moves;
    private List<Double> tStart = new ArrayList<>();
    private List<Double> tEnd = new ArrayList<>();
    public MoveCollection(double tStart, double tEnd) {
        this.moves = new HashMap<>();
        this.tStart.add(tStart);
        this.tEnd.add(tEnd);
    }

    public void addAll(String humanWalks, Move... movesAdd) {
        for (Move move : movesAdd) {
            moves.put(humanWalks, move);
        }
    }

    public Collection<Move> getMoves() {
        return moves.values();
    }
}
