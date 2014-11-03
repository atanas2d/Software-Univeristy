import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ComandLineDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String server = null; // helping var
		int port = 0; // helping var
		
		server = args[0];
		port = Integer.parseInt(args[1]);
		
		try {
			Socket ourSocket = new Socket (server, port);
			
			PrintWriter outputStream1 =
					new PrintWriter(ourSocket.getOutputStream(), true);	
			Scanner input1 = new Scanner (System.in);
			String myCommand = input1.nextLine();
			outputStream1.println(myCommand);;
			
			BufferedReader in = new BufferedReader ( new 
					InputStreamReader (ourSocket.getInputStream()));
			while (true) {
				String line = in.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Exception:" + e.toString());
		}		
	}

}
