package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class Rank {
	private List<Piece> pieces = new ArrayList<>();

	List<Piece> getPieces() {
		return this.pieces;
	}

	int getCountsOfPiece(Color color, Type type) {
		int countsOfPiece = 0;
		for (Piece piece : pieces) {
			if (piece.matchPiece(color, type)) {
				countsOfPiece++;
			}
		}
		return countsOfPiece;
	}

	static Rank initializeWhitePieces() {
		Rank rank = new Rank();
		rank.pieces.add(Piece.createWhiteRook());
		rank.pieces.add(Piece.createWhiteKnight());
		rank.pieces.add(Piece.createWhiteBishop());
		rank.pieces.add(Piece.createWhiteQueen());
		rank.pieces.add(Piece.createWhiteKing());
		rank.pieces.add(Piece.createWhiteBishop());
		rank.pieces.add(Piece.createWhiteKnight());
		rank.pieces.add(Piece.createWhiteRook());
		return rank;
	}

	static Rank initializeBlackPieces() {
		Rank rank = new Rank();
		rank.pieces.add(Piece.createBlackRook());
		rank.pieces.add(Piece.createBlackKnight());
		rank.pieces.add(Piece.createBlackBishop());
		rank.pieces.add(Piece.createBlackQueen());
		rank.pieces.add(Piece.createBlackKing());
		rank.pieces.add(Piece.createBlackBishop());
		rank.pieces.add(Piece.createBlackKnight());
		rank.pieces.add(Piece.createBlackRook());
		return rank;
	}

	static Rank initializeWhitePawns() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieces.add(Piece.createWhitePawn());
		}
		return rank;
	}

	static Rank initializeBlackPawns() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieces.add(Piece.createBlackPawn());
		}
		return rank;
	}

	public static Rank initializeBlank() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieces.add(Piece.createBlank());
		}
		return rank;
	}

	public void setPiece(Position position, Piece piece) {
		pieces.set(position.getX(), piece);
	}

	public double calculatePoint(Color color) {
		double point = 0;
		for (Piece piece : pieces) {
			if (piece.getColor() == color) {
				point += piece.getDefaultPoint();
			}
		}
		return point;
	}
}
