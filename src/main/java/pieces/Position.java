package pieces;

public class Position {
	private String position;

	public Position(String position) throws InputException {
		this.position = position;
		if (getX() < 0 || getX() > 7) {
			throw new InputException("a ~ h 사이의 문자를 입력해주세요");
		}
		if (getY() < 0 || getY() > 7) {
			throw new InputException("1 ~ 8 사이의 숫자를 입력해주세요");
		}
	}

	public int getX() {
		char x = position.charAt(0);
		return x - 'a';
	}

	public int getY() {
		char y = position.charAt(1);
		return 8 - Character.getNumericValue(y);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Position other = (Position) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [position=" + position + "]";
	}
}
