package net.honux.pieces;

import static java.lang.Character.toUpperCase;

public class Piece {

    public enum Color { BLACK, WHITE, NO_COLOR };

    private Color color;
    private Type type;
    private char representation;

    private Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
        setRepresentation();
    }

    public static Piece create(Type type, Color color) {
        return new Piece(type, color);
    }

    public static Piece copy(Piece piece) {
        return new Piece(piece.getType(), piece.getColor());
    }

    private void setRepresentation() {
        if(this.color == Piece.Color.BLACK) {
            this.representation = toUpperCase(this.type.getRepresentation());
        } else {
            this.representation = this.type.getRepresentation();
        }
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return representation;
    }
}
