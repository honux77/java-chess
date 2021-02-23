package net.honux.chess;

import net.honux.pieces.Piece;
import net.honux.pieces.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {

    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("기물이 있는 자리는 이동이 금지되어야 한다.")
    void moveFail() {
        Board.File f = Board.File.E;
        int r = 1;
        assertThat(board.movePiece(f, r, f, r)).isFalse();
    }

    @Test
    @DisplayName("피스는 이동 가능하고 이동한 자리는 빈 피스로 채워져야 한다.")
    void movePiece() {
        Board.File f1 = Board.File.B;
        Board.File f2 = Board.File.D;
        int r1 = 2;
        int r2 = 4;
        Type type = board.getPiece(f1, r1).getType();
        Piece.Color color = board.getPiece(f1, r1).getColor();
        assertThat(type).isNotEqualTo(Type.NONE);
        boolean move = board.movePiece(f1, r1, f2, r2);
        assertThat(move).isTrue();
        assertThat(board.getPiece(f1, r1).getType()).isNotEqualTo(Type.NONE);
        assertThat(board.getPiece(f2, r2).getType()).isEqualTo(type);
        assertThat(board.getPiece(f2, r2).getColor()).isEqualTo(color);
    }
}
