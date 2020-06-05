import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static int[] pac1 = {
		0b00111100,
		0b01111110,
		0b11011110,
		0b11111100,
		0b11111000,
		0b11111100,
		0b01111110,
		0b00111100
	};
	public static int[] pac2 = {
		0b00111100,
		0b01111110,
		0b11011110,
		0b11111110,
		0b11111000,
		0b11111110,
		0b01111110,
		0b00111100
	};
	public static int[] pac3 = {
		0b00111100,
		0b01111110,
		0b11011110,
		0b11111110,
		0b11111110,
		0b11111110,
		0b01111110,
		0b00111100
	};
	public static void main(String[] args) {
		Matrix m = new Matrix();
		int op;
		do {
			limpa();
			System.out.println(m.toString());
			System.out.println("--------");
			System.out.println(" 1 - Up");
			System.out.println(" 2 - Down");
			System.out.println(" 3 - Right");
			System.out.println(" 4 - Left");
			System.out.println(" 5 - Sair");
			System.out.println("--------");
			System.out.print("Opção: ");
			op = input.nextInt();
			m = handleOp(op, m);
		} while(op != 5);
	}
	public static void limpa() {
		sleep(1000);
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	public static void sleep(int s) {
		try {
			Thread.sleep(s);
		} catch(InterruptedException e) {}
	}
	public static Matrix handleOp(int op, Matrix m) {
		switch(op) {
			case 1:
				m.toTop();
				break;
			case 2:
				m.toBottom();
				break;
			case 3:
				m.toRight();
				break;
			case 4:
				m.toLeft();
				break;
		}
		return m;
	}
	public static String toBinary(int n) {
		return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
	}
	public static void printMatrix(int[] m) {
		limpa();
		for(int i=0; i<8; i++) {
			System.out.println(toBinary(m[i]));
		}
	}
	public static void printPac() {
		for(int i=0; i<3; i++) {
			printMatrix(pac1);
			printMatrix(pac2);
			printMatrix(pac3);
			printMatrix(pac2);
		}
	}
}
