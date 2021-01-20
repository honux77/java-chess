package net.honux.chess;

import net.honux.pieces.Pawn;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        assertThat(board).isNotNull();
        assertThat(board.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("보드가 생성되고 폰을 추가할 수 있어야 한다.")
    void create() {
        checkAddPawn(Pawn.WHITE, 1);
        checkAddPawn(Pawn.BLACK, 2);
    }

    void checkAddPawn(String color, int size) {
        board.add(new Pawn(color));
        assertThat(board.size()).isEqualTo(size);
        assertThat(board.getPawn(size - 1).getColor()).isEqualTo(color);
    }
}

