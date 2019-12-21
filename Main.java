/*Written by Adama Camara
 * Main program launch the GUI that will provide the menu for 
 * the encryption and decryption using Ceaser.java*/
import java.awt.EventQueue;

public class Main {
	public static void main( String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
				    frame.getComponents();
				    frame.getContentPane();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
