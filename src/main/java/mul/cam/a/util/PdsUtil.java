package mul.cam.a.util;

import java.util.Date;

public class PdsUtil {

	// 파일명 -> 변경(time)
	
	// myfile.txt -> 34245632.txt
	public static String getNewFileName(String fn) {
		String newfilename = "";
		String fpost = "";
		
		if(fn.indexOf('.') >= 0) {	// 확장자명이 있음
			fpost = fn.substring(fn.indexOf('.'));	// .txt
			newfilename = new Date().getTime() + fpost;	// 34245634 + .txt
		}else {		// 확장자명이 없음
			newfilename = new Date().getTime() + ".back";	// 34245634 + .back
		}
		
		return newfilename;
	}
}
