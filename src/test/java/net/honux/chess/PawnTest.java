package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흑백 객체가 잘 생성되는지 확인")
    void create() {
        String white = "white";
        String black = "black";
        Pawn p1 = new Pawn(white);
        Pawn p2 = new Pawn(black);

        assertThat(p1.getColor()).isEqualTo(white);
        assertThat(p2.getColor()).isEqualTo(black);

    }
}
