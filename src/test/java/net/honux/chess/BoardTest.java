package net.honux.chess;

import net.honux.pieces.Piece;
import net.honux.pieces.Type;
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
    void checkBlackRepresentation() {
        String blankRank = "........\n";
        assertThat(board.getDisplayString()).isEqualTo(
                "RNBQKBNR\n" + "PPPPPPPP\n" + blankRank + blankRank + blankRank + blankRank + "pppppppp\n" + "rnbqkbnr\n"
        );
    }

    @Test
    @DisplayName("특정 위치의 기물을 확인할 수 있어야 한다.")
    void getPiece() {
        assertThat(board.getPiece(Board.File.A, 1).getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(board.getPiece(Board.File.A, 2).getColor()).isEqualTo(Piece.Color.WHITE);
        assertThat(board.getPiece(Board.File.A, 1).getType()).isEqualTo(Type.ROOK);
        assertThat(board.getPiece(Board.File.A, 2).getType()).isEqualTo(Type.PAWN);

        assertThat(board.getPiece(Board.File.E, 7).getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(board.getPiece(Board.File.E, 8).getColor()).isEqualTo(Piece.Color.BLACK);
        assertThat(board.getPiece(Board.File.E, 7).getType()).isEqualTo(Type.PAWN);
        assertThat(board.getPiece(Board.File.E, 8).getType()).isEqualTo(Type.KING);
    }

    @Test
    @DisplayName("흑백 피스 각각의 개수를 리턴해야 한다")
    void getCount() {
        assertThat(board.size()).isEqualTo(64);
        assertThat(board.size(Piece.Color.WHITE)).isEqualTo(16);
        assertThat(board.size(Piece.Color.BLACK)).isEqualTo(16);
    }

    @Test
    @DisplayName("흑백 진영별로 점수를 계산해서 리턴해야 한다")
    void getScore() {
        double fullScore = 9 + 5 * 2 + 3 * 2 + 2.5 * 2 + 8 * 0.5;
        assertThat((board.getScore(Piece.Color.WHITE))).isEqualTo(fullScore);
        assertThat((board.getScore(Piece.Color.BLACK))).isEqualTo(fullScore);
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


