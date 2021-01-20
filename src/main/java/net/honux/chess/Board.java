package net.honux.chess;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Pawn> pawnList = new ArrayList<>();

    public int getSize() {
        return pawnList.size();
    }

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public Pawn getPawn(int index) {
        return pawnList.get(index);
    }
}
