package net.honux.pieces;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흑백 객체가 생성되어야 한다.")
    void create() {
        verifyPawn(Pawn.WHITE);
        verifyPawn(Pawn.BLACK);
    }

    @Test
    @DisplayName("기본 생성자로 흰색 폰이 생성되어야 한다.")
    void createDefault() {
        Pawn p = new Pawn();
        assertThat(p.getColor()).isEqualTo(Pawn.WHITE);
    }

    void verifyPawn(String color) {
        assertThat(new Pawn(color).getColor()).isEqualTo(color);
    }
}
