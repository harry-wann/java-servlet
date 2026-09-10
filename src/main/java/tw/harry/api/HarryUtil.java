package tw.harry.api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class HarryUtil {
	
	public static String loadView() throws Exception {
		
		var source = "C:\\Users\\User\\Desktop\\EEIT25\\JAVA\\HarryWeb\\src\\main\\webapp\\views\\view1.html";
		var bin = new BufferedInputStream(new FileInputStream(source));
		byte[] buf = bin.readAllBytes();
		bin.close();
	
		return new String(buf);
	}

}
