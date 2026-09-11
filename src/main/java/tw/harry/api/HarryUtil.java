package tw.harry.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class HarryUtil {
	
	public static String loadView(String source) throws Exception {
		
		var bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf = bin.readAllBytes();
		bin.close();
	
		return new String(buf);
	}

}
