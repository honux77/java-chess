package pieces;

public class Piece {
	public enum Color {
		WHITE, BLACK, NO_COLOR;
	}

	public enum Type {
		PAWN('p', 1.0),
		ROOK('r', 5.0),
		KNIGHT('n', 2.5),
		BISHOP('b', 3.0),
		QUEEN('q', 9.0),
		KING('k', 0.0),
		NO_PIECE('.', 0.0);

		private char representation;
		private double defaultPoint;

		private Type(char representation, double defaultPoint) {
			this.representation = representation;
			this.defaultPoint = defaultPoint;
		}

		public char getWhiteRepresentation() {
			return this.representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(this.representation);
		}

		public double getDefaultPoint() {
			return defaultPoint;
		}
	}

	private Color color;
	private Type type;

	public Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}
	
	public double getDefaultPoint() {
		return type.defaultPoint;
	}

	public char getRepresentation() {
		if (this.isWhite()) {
			return this.type.getWhiteRepresentation();
		}
		return this.type.getBlackRepresentation();
	}

	private boolean matchColor(Color color) {
		return this.color == color;
	}

	private boolean matchType(Type type) {
		return this.type == type;
	}

	public boolean matchPiece(Color color, Type type) {
		return matchColor(color) && matchType(type);
	}

	public static Piece createWhite(Type type) {
		return new Piece(Color.WHITE, type);
	}

	public static Piece createBlack(Type type) {
		return new Piece(Color.BLACK, type);
	}

	public static Piece createWhitePawn() {
		return createWhite(Type.PAWN);
	}

	public static Piece createBlackPawn() {
		return createBlack(Type.PAWN);
	}

	public static Piece createWhiteKnight() {
		return createWhite(Type.KNIGHT);
	}

	public static Piece createBlackKnight() {
		return createBlack(Type.KNIGHT);
	}

	public static Piece createWhiteRook() {
		return createWhite(Type.ROOK);
	}

	public static Piece createBlackRook() {
		return createBlack(Type.ROOK);
	}

	public static Piece createWhiteBishop() {
		return createWhite(Type.BISHOP);
	}

	public static Piece createBlackBishop() {
		return createBlack(Type.BISHOP);
	}

	public static Piece createWhiteQueen() {
		return createWhite(Type.QUEEN);
	}

	public static Piece createBlackQueen() {
		return createBlack(Type.QUEEN);
	}

	public static Piece createWhiteKing() {
		return createWhite(Type.KING);
	}

	public static Piece createBlackKing() {
		return createBlack(Type.KING);
	}

	public static Piece createBlank() {
		return new Piece(Color.NO_COLOR, Type.NO_PIECE);
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}

	public boolean isWhite() {
		return this.color == Color.WHITE;
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
