package 스택;

import java.util.*;
import java.io.*;

public class BOJ_9093 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<T; i++) {
			Stack<Character> st = new Stack<>();
			String line = sc.nextLine();
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == ' ') {
					while (!st.empty()) {
						System.out.print(st.pop());
					}
					System.out.print(" ");
				} else {
					st.push(line.charAt(j));
				}
			}
			while(!st.empty()) {
				System.out.print(st.pop());
			}
			System.out.println();
		}
		sc.close();
	}
}
