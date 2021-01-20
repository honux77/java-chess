package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("흑백 객체가 잘 생성되는지 확인")
    void create() {
        final String white = "white";
        final String black = "black";
        verifyPawn(white);
        verifyPawn(black);
    }

    void verifyPawn(String color) {
        assertThat(new Pawn(color).getColor()).isEqualTo(color);
    }
}
