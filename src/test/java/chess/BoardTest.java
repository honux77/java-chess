package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class BoardTest {
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void getMatchCountOfPieceTest() throws Exception {
		board.initialize();
		assertEquals(8, board.getMatchCountsOfPiece(Color.WHITE, Type.PAWN));
		assertEquals(2, board.getMatchCountsOfPiece(Color.BLACK, Type.BISHOP));
		assertEquals(2, board.getMatchCountsOfPiece(Color.WHITE, Type.KNIGHT));
		assertEquals(2, board.getMatchCountsOfPiece(Color.BLACK, Type.ROOK));
		assertEquals(1, board.getMatchCountsOfPiece(Color.WHITE, Type.KING));
		assertEquals(32, board.getMatchCountsOfPiece(Color.NO_COLOR, Type.NO_PIECE));
	}

	@Test
	public void findPiece() throws Exception {
		board.initialize();
		assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
		assertEquals(Piece.createBlackKnight(), board.findPiece("g8"));
		assertEquals(Piece.createWhiteBishop(), board.findPiece("c1"));
		assertEquals(Piece.createWhiteKing(), board.findPiece("e1"));
	}

	@Test
	public void showBoard() {
		System.out.println(board.showBoard());
	}

	@Test
	public void move() throws Exception {
		board.initializeEmpty();

		String position = "c6";
		Piece piece = Piece.createBlackRook();
		board.move(position, piece);

		assertEquals(piece, board.findPiece(position));
		System.out.println(board.showBoard());
	}

	@Test
	public void calculcatePoint() throws Exception {
		board.initializeEmpty();

		addPiece("b6", Piece.createBlackPawn());
		addPiece("e6", Piece.createBlackQueen());
		addPiece("b8", Piece.createBlackKing());
		addPiece("c8", Piece.createBlackRook());

		addPiece("f2", Piece.createWhitePawn());
		addPiece("g2", Piece.createWhitePawn());
		addPiece("e1", Piece.createWhiteRook());
		addPiece("f1", Piece.createWhiteKing());

		assertEquals(15.0, board.calculcatePoint(Color.BLACK), 0.01);
		assertEquals(7.0, board.calculcatePoint(Color.WHITE), 0.01);

		System.out.println(board.showBoard());
	}

	private void addPiece(String position, Piece piece) {
		board.move(position, piece);
	}
}
