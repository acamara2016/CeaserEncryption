/*Written by Adama Camara
 * GUI.java is the file made from Eclipse IDE Swing
 * It provide the user with a menu that will allow them to 
 * encrypt or decrypt a given string*/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCc = new JLabel("Ceaser Encryption");
		lblCc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCc.setBounds(141, 13, 157, 14);
		contentPane.add(lblCc);
		
		JEditorPane txtToDecrypt = new JEditorPane();
		txtToDecrypt.setBounds(10, 254, 454, 118);
		contentPane.add(txtToDecrypt);
		
		JEditorPane txtToEncrypt = new JEditorPane();
		txtToEncrypt.setBounds(10, 91, 454, 118);
		contentPane.add(txtToEncrypt);
		
		JButton btEncrypt = new JButton("Encrypt");
		btEncrypt.setBounds(141, 220, 89, 23);
		contentPane.add(btEncrypt);
		
		JButton btDecrypt = new JButton("Decrypt");
		btDecrypt.setBounds(250, 220, 89, 23);
		contentPane.add(btDecrypt);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 59, 132, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(152, 59, 132, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblPasswordAreThe = new JLabel("Password are the same");
		lblPasswordAreThe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswordAreThe.setForeground(Color.GREEN);
		lblPasswordAreThe.setBounds(294, 62, 149, 14);
		contentPane.add(lblPasswordAreThe);
		
		JLabel lblPasswordsAreNot = new JLabel("Passwords are not the same");
		lblPasswordsAreNot.setForeground(Color.RED);
		lblPasswordsAreNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswordsAreNot.setBounds(294, 62, 170, 14);
		contentPane.add(lblPasswordsAreNot);
		
		JLabel wrongPass = new JLabel("Wrong password");
		wrongPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		wrongPass.setForeground(Color.RED);
		wrongPass.setBounds(293, 62, 96, 14);
		contentPane.add(wrongPass);
		
		JLabel lblCorrectPassword = new JLabel("Correct password");
		lblCorrectPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorrectPassword.setForeground(Color.GREEN);
		lblCorrectPassword.setBounds(294, 62, 149, 14);
		contentPane.add(lblCorrectPassword);
		
		JLabel lblEnterYourSecret = new JLabel("Enter your secret key");
		lblEnterYourSecret.setBounds(10, 38, 132, 14);
		contentPane.add(lblEnterYourSecret);
		
		JLabel lblConfirmYourSecret = new JLabel("Confirm your secret key");
		lblConfirmYourSecret.setBounds(152, 38, 132, 14);
		contentPane.add(lblConfirmYourSecret);
		lblPasswordAreThe.setVisible(false);
		lblPasswordsAreNot.setVisible(false);
		lblCorrectPassword.setVisible(false);
		wrongPass.setVisible(false);
		if(!(passwordField.getText().equals("")) && !(passwordField_1.getText().equals(""))) {
			if((passwordField.getText()).equals(passwordField_1.getText())) {
				lblPasswordAreThe.setVisible(true);
				 
			}
			else {
				lblPasswordsAreNot.setVisible(true);
			}
		}
		ArrayList<String> List=new ArrayList<String>();
		btDecrypt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {//method used when user want to encrypt
				lblPasswordAreThe.setVisible(false);
				lblPasswordsAreNot.setVisible(false);
				lblCorrectPassword.setVisible(false);
				wrongPass.setVisible(false);
				Ceaser c=new Ceaser();
				if(List.contains(passwordField.getText())) {
					lblPasswordAreThe.setVisible(false);
					lblPasswordsAreNot.setVisible(false);
					lblCorrectPassword.setVisible(true);
					wrongPass.setVisible(false);
					String dencrypted=c.Deshift(txtToEncrypt.getText());
					txtToDecrypt.setText(dencrypted);
				}else {
					lblCorrectPassword.setVisible(false);
					wrongPass.setVisible(true);
				}
			}
		});
		btEncrypt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {//method used when user want to decrypt
				lblPasswordAreThe.setVisible(false);
				lblPasswordsAreNot.setVisible(false);
				Ceaser c=new Ceaser();
				if(!(passwordField.getText().equals("")) && !(passwordField_1.getText().equals(""))) {
					if((passwordField.getText()).equals(passwordField_1.getText())) {
						lblPasswordAreThe.setVisible(true);
						String encrypted=c.shift(txtToEncrypt.getText());
						txtToDecrypt.setText(encrypted);
						List.add(passwordField.getText());
					}
					else {
						lblPasswordsAreNot.setVisible(true);
					}
				}
			}
		});
	}
}
