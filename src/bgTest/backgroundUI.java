package bgTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class backgroundUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					backgroundUI frame = new backgroundUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public backgroundUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1032, 894);// bug: not equal image size for some reasons
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//adding layered pane
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane);

		//setting up top and bottom layers
		JPanel top = new JPanel();
		top.setBounds(173, 97, 672, 676); //size and position of the board
		JPanel bottom = new JPanel();
		bottom.setBounds(0, 0, 1024, 863); //= image size
		layeredPane.setLayout(null); //layered pane uses absolute layout
		layeredPane.add(top);
		layeredPane.add(bottom);
	
		
		
		//adding background image on bottom layer
		bottom.setLayout(null); //bottom layer uses absolute layout
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1024, 863);
		lblNewLabel.setIcon(new ImageIcon("D:\\Java folder\\board.jpg")); //change the path to your image
		bottom.add(lblNewLabel);
		
		//set top layer transparent and adding grid layout
		top.setOpaque(false);
		top.setLayout(new GridLayout(2, 2, 0, 0)); //it should be 7x7 grid but this for testing purpose
		
		//make 4 labels on top layer for testing, 49 labels can be added by using arrays JButton[]
		JLabel lblNewLabel_1 = new JLabel("");
		top.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		top.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		top.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		top.add(lblNewLabel_4);
		
		//adding mouse event on label click
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_4.setIcon(new ImageIcon("D:\\Java folder\\ship.png")); //change the path to your image
				
				//centered the image on the label
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setVerticalAlignment(SwingConstants.CENTER);
			}
		});

	}

}
