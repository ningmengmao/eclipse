package mypackage.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/mypackage/IO/FileTest/1"));
		Map<Character, Integer> map = new HashMap<>();
		
		int in;
		while((in = br.read()) != -1) {
			char ch = (char)in;
			if(map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
			// map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 ; 1)
		}
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/mypackage/IO/FileTest/3.txt"));
		for (Character c : map.keySet()) {
			switch (c) {
			case '\t':
				bw.write( "\\t" + " = " + map.get(c));
				break;
			case '\n':
				bw.write( "\\n" + " = " + map.get(c));
				break;
			case '\r':
				bw.write( "\\r" + " = " + map.get(c));
				break;
			default:
				bw.write( c + " = " + map.get(c));
			}
			bw.newLine();
		}
		bw.close();
	}

}
