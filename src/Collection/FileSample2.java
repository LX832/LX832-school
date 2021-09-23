package Collection;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * 파일에 대한 처리 : input(keyboard)/output(monitor) 
 * 
 * 2. 복사본 파일을 읽어서 화면상에 출력합니다
 * 
 * 
 */
public class FileSample2 {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("c:\\Filetest\\hello.txt");

		while (true) {
			int read = is.read();
			if (read == -1) {
				break;
			}
			System.out.println((char) read);
		}
	}

}

/*
 * bit => byte => word => field => record => block => file => Database =>
 * DataBank
 * 
 * 
 *
 *
 */