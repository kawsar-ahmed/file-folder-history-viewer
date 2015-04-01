package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import windowsevent.EventCollector;

public class MainUI {

	private JFrame frame;
	private JTextPane textPane;
	private JButton refreshButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
		loadEventData(textPane);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		refreshButton = new JButton("Refresh");
		refreshButton.setSize(10, 5);
		frame.getContentPane().add(refreshButton, BorderLayout.EAST);
		refreshButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				loadEventData(textPane);
			}
		});
		
		
	}

	private void loadEventData(final JTextPane textPane) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				
				EventCollector eventCollector = new EventCollector();
				String eventsText = eventCollector.getEvents();
				textPane.setText(eventsText);
			}
		});
	}

}
