package pieces;

import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Piece.Type;

public class PieceTest {
	Piece piece;

	@Test
	public void getRpresentationTest() throws Exception {
		assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
		assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
	}

	@Test
	public void cretePieceTest() throws Exception {
		verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
		verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
		verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
		verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
		verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
		verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);
		Piece blank = Piece.createBlank();
		assertFalse(blank.isWhite());
		assertFalse(blank.isBlack());
		assertEquals(Type.NO_PIECE, blank.getType());
	}

	@Test
	public void checkColorTest() throws Exception {
		Piece black = new Piece(Piece.Color.BLACK, Piece.Type.PAWN);
		assertTrue(black.isBlack());
		Piece white = new Piece(Piece.Color.WHITE, Piece.Type.PAWN);
		assertTrue(white.isWhite());
	}

	private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
