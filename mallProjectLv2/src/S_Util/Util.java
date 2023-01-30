package S_Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	static public Scanner scan = new Scanner(System.in);
	
	public static int getInt(int start, int end) {
		int input=0;
		while (true) {
			try {
				System.out.print("입력 : ");
				input = scan.nextInt();
				if(input<start||input>end) {
					throw new Exception();
				}
			} catch (InputMismatchException e) {
				System.err.println("문자 입력 불가");
				scan.nextLine();
				continue;
			} catch (Exception e) {
				System.err.println("범위 오류");
				continue;
			}
			break;
		}
		return input;
	}
	public static String getString(String msg) {
		
		System.out.print(msg+" 입력 : ");
		
		String input = scan.next();
		
		return input;
	}
}
