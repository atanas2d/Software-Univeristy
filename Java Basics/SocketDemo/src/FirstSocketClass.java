import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class FirstSocketClass {	

	public static void main(String[] args) { 	 
		// TODO Reading ftp site 
		try {
			byte[] array = new byte[1000];
			array[0]=0;
			Socket ourSocket = new Socket ("localhost", 3333);
			BufferedReader in = new BufferedReader ( new 
					InputStreamReader (ourSocket.getInputStream()));
			while (true) {
				String line = in.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			
			System.out.println("HAHA end");
			
			in.close();
		} catch (Exception e) {
			System.out.println("HAHA end 2" + e.toString());
		}		
		System.out.println("HAHA end 3");
		
	}

}
