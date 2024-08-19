import javax.swing.JFrame;

public class MainClient extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Client client = new Client();
	
	public MainClient() {
		this.setTitle("Client Ball");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.setSize(600,800);
		
		this.add(client);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	

public static void main(String[] args) {
	new MainClient();
}

}
