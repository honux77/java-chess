package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {

    @Test
    @DisplayName("보드가 생성되고 폰을 추가할 수 있어야 한다.")
    void create() {
        Board board = new Board();
        assertThat(board).isNotNull();
        assertThat(board.getSize()).isEqualTo(0);
        board.add(new Pawn());
        assertThat(board.getSize()).isEqualTo(1);
        assertThat(board.getPawn(0).getColor()).isEqualTo(Pawn.WHITE);
        board.add(new Pawn(Pawn.BLACK));
        assertThat(board.getSize()).isEqualTo(2);
        assertThat(board.getPawn(1).getColor()).isEqualTo(Pawn.BLACK);
    }
}
