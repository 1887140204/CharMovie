package CharMovie;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner cin = new Scanner(System.in);
	public static String MvName;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("«Î ‰»Î∂Øª≠√˚:");
		MvName = cin.nextLine();
		PrintChar d = new PrintChar(MvName + "\\Animation.txt", MvName + "\\FrameDemo.txt");
		Thread t = new Thread(new PlayMusic());
		t.start();
		d.Show();
		Thread.sleep(900);
		d.Run();
	}
}
