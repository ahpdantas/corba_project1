package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private LayoutManager layout;
	private JTextArea clientLog;
	private JButton btnRequest;
	private JButton btnRelease;
		
	public ClientApp(){
		
		layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel Panel = new JPanel();
				
		clientLog = new JTextArea(13,15);
		clientLog.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
		clientLog.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(clientLog);
		
	    btnRequest = new JButton("Request");
	    btnRequest.setToolTipText("Request acess to critic space");
		
	    btnRelease = new JButton("Release");
	    btnRequest.setToolTipText("Release resource");

	    Panel.add(new JLabel("Client Log"));
	    Panel.add(scroll);
		Panel.add(btnRequest);
		Panel.add(btnRelease);
		
		this.add(Panel);
		
	    this.setVisible(true);
	    this.setSize(200, 320);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientApp app = new ClientApp();
	}

}
