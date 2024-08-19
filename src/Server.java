 import java.awt.Color;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class Server extends JFrame {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Socket socket1;
	static Socket socket2;
	
 
	DataInputStream inputStream;
	DataOutputStream outputStream;
	
	public int  OneSocket1() throws IOException
	{
		
		 inputStream = new DataInputStream(socket1.getInputStream());
		
		int x = inputStream.readInt();
		
		return x;
		
	}
	public int  OneSocket2() throws IOException
	{
		
		 inputStream = new DataInputStream(socket2.getInputStream());
		
		int xVe = inputStream.readInt();
		
		return xVe;
		
	}
	
	public void OneSocket(int xVe,int xBall,int yBall,String diem,String diem1) throws IOException
	{
		outputStream = new DataOutputStream(socket1.getOutputStream());
		
		outputStream.writeInt(xVe);
		
		outputStream.writeInt(xBall);
		
		outputStream.writeInt(yBall);
		outputStream.writeUTF(diem1);
		outputStream.writeUTF(diem);
		outputStream.flush();
	}
	public void TwoSocket(int x,int xBall,int yBall,String diem,String diem1) throws IOException
	{
		outputStream = new DataOutputStream(socket2.getOutputStream());
		
		outputStream.writeInt(x);
		
		outputStream.writeInt(xBall);
	
		outputStream.writeInt(yBall);
		outputStream.writeUTF(diem);
		outputStream.writeUTF(diem1);
		outputStream.flush();
	}
	
	public static void main(String[] args) throws IOException {
		JTextArea textField = new JTextArea();
		
		JFrame frame = new JFrame("Server");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(500,500);
		textField.setSize(500,500);
		textField.setEditable(false);
		textField.setFont(new Font(" ", Font.BOLD, 20));
		frame.setVisible(true);
		frame.add(textField);
		ServerSocket serverSocket = new ServerSocket(1234);
		textField.setBackground(Color.CYAN);

	    String text = "\n \n";
		text+="   Server:  đang đợi người chơi thứ nhất \n";
		textField.setText(text);
		
 		socket1 = serverSocket.accept();
	   
 		text+="   Server: đang đợi người chơi thứ hai \n";
 		textField.setText(text);
	    socket2 = serverSocket.accept();
		textField.setText("  Server: Playing");
	    BallServer ballServer = new BallServer();
	  
	   
		
	}

	

}
