package chess;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("start or end ? : ");
			String input = sc.nextLine();
			if (input.equals("start")) {
				Board board = new Board();
				board.initialize();
				System.out.println(board.showBoard());
			} else if (input.equals("end")) {
				break;
			} else {
				System.out.println("다시 입력해주세요");
			}
		}

		sc.close();
	}
}
