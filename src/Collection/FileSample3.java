package Collection;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * 파일에 대한 처리 : input(keyboard)/output(monitor) 
 * 
 * 2. 복사본 파일을 읽어서 화면상에 출력합니다
 * 
 * 
 */
public class FileSample3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		FileWriter fw = new FileWriter("");

		while (true) {
			String read = br.readLine();
			if (read == null) {
				break;
			}
			System.out.println(read);
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