package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import CoordinatorApp.Coordinator;

public class ClientGui extends JFrame implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	private LayoutManager layout;
	private JTextArea clientLog;
	private JButton btnRequest;
	private JButton btnRelease;
	private String ID;
	private Coordinator coordinator;
	
	public ClientGui(String ID, Coordinator coordinator){
		this.ID = ID;
		this.coordinator = coordinator;
		layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel Panel = new JPanel();
				
		clientLog = new JTextArea(13,15);
		clientLog.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
		clientLog.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(clientLog);
		
	    btnRequest = new JButton("Request");
	    btnRequest.addActionListener(this);
	    btnRequest.setToolTipText("Request acess to critic space");
		
	    btnRelease = new JButton("Release");
	    btnRelease.addActionListener(this);
	    btnRelease.setEnabled(false);
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

	public void log(String msg){
		clientLog.append(msg);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command = arg0.getActionCommand();
		if( command.equals("Request")){
			this.coordinator.request(this.ID);
			this.btnRequest.setEnabled(false);
			this.btnRelease.setEnabled(true);
		}else if( command.equals("Release")){
			this.coordinator.release(this.ID);
			this.log(this.ID + "releasing the critical session\r\n");
			this.btnRequest.setEnabled(true);
			this.btnRelease.setEnabled(false);
		}
		
	}

}
