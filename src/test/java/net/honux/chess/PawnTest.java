package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흑백 객체가 잘 생성되는지 확인")
    void create() {
        String white = "white";
        String black = "black";
        createAndVerifyPawn(white);
        createAndVerifyPawn(black);
    }

    void createAndVerifyPawn(final String color) {
        Pawn p = new Pawn(color);
        assertThat(p.getColor()).isEqualTo(color);
    }
}
