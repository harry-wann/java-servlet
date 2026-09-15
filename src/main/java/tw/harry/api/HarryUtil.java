package tw.harry.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class HarryUtil {
	
	public static String loadView(String source) throws Exception {
		
		var bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf = bin.readAllBytes();
		bin.close();
	
		return new String(buf);
	}

	public static String calc(String x, String y) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			return (intX + intY) + "";
		} catch (Exception e) {
			return "";
		}
	}

	public static int createScore() {
		return new Random().nextInt(101);
	}
	
	public static SortedMap[] parseFarms(String json) {
		
		
		return null;
	}
}
