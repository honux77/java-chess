package net.honux.chess;

import net.honux.pieces.Piece;
import net.honux.pieces.Type;

public class Board {

    private final static int W = 8;
    private final static int H = 8;
    private int size = 0;
    private Piece[][] pieces = new Piece[H][W];

    public Piece getPiece(File file, int rank) {
        return pieces[rank - 1][file.getColumn()];
    }

    public int size(Piece.Color color) {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (pieces[i][j].getColor() == color) count++;
            }
        }
        return count;
    }

    public double getScore(Piece.Color color) {
        double score = 0.0f;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (pieces[i][j].getColor() == color) score += pieces[i][j].getType().getScore();
            }
        }
        score -= disadantagePawn(color);
        return score;
    }

    private double disadantagePawn(Piece.Color color) {
        double minus = 0.0f;
        for (int i = 0; i < H; i++) {
            int pawnCount = 0;
            for (int j = 0; j < W; j++) {
                if (pieces[i][j].getColor() == color && pieces[i][j].getType() == Type.PAWN) pawnCount++;
            }
            if (pawnCount > 1) minus += pawnCount * 0.5;
        }
        return minus;
    }

    public boolean movePiece(File f1, int r1, File f2, int r2) {
        if (getPiece(f2, r2).getType() != Type.NONE) return false;
        Piece newPiece = Piece.copy(getPiece(f1, r1));
        setPiece(newPiece, f2, r2);
        return true;
    }

    public enum File {
        A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7);
        private static File[] values = File.values();

        public File next() {
            return values[(this.ordinal() + 1) % values.length];
        }

        private int column;

        File(int column) {
            this.column = column;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public Board() {
        setEmptyPieces();
        addOthers(Piece.Color.BLACK);
        addPawns(Piece.Color.BLACK);
        addPawns(Piece.Color.WHITE);
        addOthers(Piece.Color.WHITE);
    }

    public int size() {
        return size;
    }

    public String getDisplayString() {
        StringBuilder sb = new StringBuilder();

        for (int i = H - 1; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                sb.append(pieces[i][j].getRepresentation());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void print() {
        System.out.print(getDisplayString());
    }

    public void setPiece(Piece piece, File file, int rank) {
        pieces[rank - 1][file.getColumn()] = piece;
    }

    private void setEmptyPieces() {
        //TODO: refactor using setPiece
        int[] emptyRank = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i : emptyRank) {
            for (int j = 0; j < W; j++) {
                pieces[i - 1][j] = Piece.create(Type.NONE, Piece.Color.NO_COLOR);
                size++;
            }
        }
    }

    private void addOthers(Piece.Color color) {
        int rank = 1;
        if (color == Piece.Color.BLACK) rank = 8;
        setPiece(Piece.create(Type.ROOK, color), File.A, rank);
        setPiece(Piece.create(Type.ROOK, color), File.H, rank);
        setPiece(Piece.create(Type.KNIGHT, color), File.B, rank);
        setPiece(Piece.create(Type.KNIGHT, color), File.G, rank);
        setPiece(Piece.create(Type.BISHOP, color), File.C, rank);
        setPiece(Piece.create(Type.BISHOP, color), File.F, rank);
        setPiece(Piece.create(Type.QUEEN, color), File.D, rank);
        setPiece(Piece.create(Type.KING, color), File.E, rank);
    }

    private void addPawns(Piece.Color color) {
        int rank = 2;
        if (color == Piece.Color.BLACK) rank = 7;
        File curr = File.A;
        for (int i = 0; i < W; i++) {
            setPiece(Piece.create(Type.PAWN, color), curr, rank);
            curr = curr.next();
        }
    }

}
