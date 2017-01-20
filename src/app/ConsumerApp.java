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

public class ConsumerApp extends JFrame {
	static final long serialVersionUID = 1L;
	private LayoutManager layout;
	private JTextArea consumerLog;
	private JTextArea processQueue;
		
	
	public ConsumerApp(){
		
		layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel mainPanel = new JPanel();
		this.add(mainPanel);
		
		JPanel consumerPanel = new JPanel();
		consumerPanel.setLayout(new BoxLayout(consumerPanel, BoxLayout.Y_AXIS));
				
		consumerLog = new JTextArea(20,30);
		consumerLog.setBorder(BorderFactory.createEtchedBorder(Color.BLUE,Color.BLUE));
		consumerLog.setEditable(false);
		
		consumerPanel.add(new JLabel("Consumer Log"));
		consumerPanel.add(new JScrollPane(consumerLog));
		
				
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsumerApp app = new ConsumerApp();

	}

}
