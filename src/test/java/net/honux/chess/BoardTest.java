package net.honux.chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스보드 초기화시 크기는 64여야 한다")
    public void initAllPieceSize() {
        assertThat(board).isNotNull();
        assertThat(board.size()).isEqualTo(64);
    }

    @Test
    @DisplayName("체스 File A의 값은 0이고 H의 값은 7 이어야 한다.")
    void fileValue() {
        assertThat(Board.File.A.getColumn()).isEqualTo(0);
        assertThat(Board.File.H.getColumn()).isEqualTo(7);
    }

    @Test
    @DisplayName("File의 next()연산자가 정상 동작해야 한다.")
    void fileNext() {
        //TODO: implement
        assertThat(Board.File.A.next()).isEqualTo(Board.File.B);
    }

    @Test
    @DisplayName("체스보드 초기화후 각 기물들이 제자리이 있어야 한다")
    public void checkBlackRepresentation() {
        String blankRank = "........\n";
        assertThat(board.getDisplayString()).isEqualTo(
                "RNBQKBNR\n" + "PPPPPPPP\n" + blankRank + blankRank + blankRank + blankRank + "pppppppp\n" + "rnbqkbnr\n"
        );
    }
}


