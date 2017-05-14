package CharMovie;

import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintChar {
	int i = 1;
	char[] carr;
	BufferedReader bur;
	Frame f;
	TextArea ta;
	String data;
	String Animation;
	String FrameDemo;

	PrintChar(String Animation, String FrameDemo) {
		System.out.println("初始化中……");
		this.Animation = Animation;
		this.FrameDemo = FrameDemo;
		f = new Frame("CharMovie");
		ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_NONE);
		ta.setFont(new Font("黑体", Font.PLAIN, 7));
		try {
			bur = new BufferedReader(new FileReader(Animation));
			carr = new char[GetFrame()];
		} catch (IOException e1) {
			System.out.println("!初始化失败!");
			System.exit(1);
		}
		f.add(ta);
		f.setBounds(50, 0, 1150, 1000);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		data = new String(carr, 0, i);
		System.out.println("初始化 OK");
	}

	public void Show() {
		f.setVisible(true);
	}

	public void Run() {
		System.out.println("开始播放");
		try {
			while ((i = bur.read(carr)) != -1) {
				ta.setText(new String(carr, 0, i));
				Thread.sleep(75);
			}
		} catch (Exception e) {
			System.out.println("!运行异常!");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int GetFrame() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader fr = new BufferedReader(new FileReader(FrameDemo));
		int i = 0;
		int x = 1;
		char[] carrg = new char[1024];
		while (i != -1) {
			i = fr.read(carrg);
			x = x + i;
		}
		return x;
	}
}