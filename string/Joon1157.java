package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Joon1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = (br.readLine()).toUpperCase();
		int[] arr = new int[26];
		
		
		for(int i = 0; i < input.length(); i++) {
			char at = input.charAt(i);
			arr[at - 65]++;				
		}
		
		int max = -1;
		char ch = '?';
		for(int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				ch = (char)(i + 65);
			}else if(arr[i] == max) {
				ch ='?';
			}
		}
		
		System.out.println(ch);
		
		
		
		
	}//main

}//class
