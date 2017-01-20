package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CoordinatorGui extends JFrame implements ActionListener, KeyListener {
	static final long serialVersionUID = 1L;
	private LayoutManager layout;
	private JTextArea coordinatorLog;
	private JTextArea processQueue;
	
	public CoordinatorGui(){
		layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		
		JPanel consumerPanel = new JPanel();
		consumerPanel.setLayout(new BoxLayout(consumerPanel, BoxLayout.Y_AXIS));
				
		coordinatorLog = new JTextArea(20,30);
		coordinatorLog.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
		coordinatorLog.setEditable(false);
		
		consumerPanel.add(new JLabel("Consumer Log"));
		consumerPanel.add(new JScrollPane(coordinatorLog));
		
				
		JPanel queuePanel = new JPanel();
		queuePanel.setLayout(new BoxLayout(queuePanel, BoxLayout.Y_AXIS));
	
		processQueue = new JTextArea(20,5);
		processQueue.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
		processQueue.setEditable(false);
				
		queuePanel.add(new JLabel("Process Queue"));
		queuePanel.add(new JScrollPane(processQueue));
		
		mainPanel.add(consumerPanel);
		mainPanel.add(queuePanel);
		
	    this.setVisible(true);
	    this.setSize(500, 400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void log(String msg){
		coordinatorLog.append(msg);
	}
	
	public void addToQueueLog(String processID){
		
	}
	
	public void removeFromQueueLog(){
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
