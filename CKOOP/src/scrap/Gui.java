package scrap;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import allc.eventhistory;
import allc.festival;
import allc.hisfigu;
import allc.historicalplace;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cạo Dữ Liệu Tự Động");
		lblNewLabel.setBounds(39, 28, 191, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Scrape");
		btnNewButton.addActionListener(new ActionListener() {
			private ArrayList<festival> list;

			public void actionPerformed(ActionEvent e) {
				scrapFestival scrapFestival = new scrapFestival();
		    	try {
					scrapFestival.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	list = scrapFestival.list;
		    	GUI_Festival gui_Festival=new GUI_Festival();
		    	try {
					GUI_Festival.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(239, 45, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save data");
		btnNewButton_1.addActionListener(new ActionListener() {
			private ArrayList<festival> list;

			public void actionPerformed(ActionEvent e) {
				scrapFestival scrapFestival = new scrapFestival();
		    	try {
					scrapFestival.run();
					scrapFestival.saveJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	//list = scrapFestival.list;
		    	
			}
		});
		btnNewButton_1.setBounds(338, 45, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm");
		lblNewLabel_2.setBounds(39, 210, 191, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(282, 204, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nhân vật lịch sử");
		lblNewLabel_3.setBounds(39, 77, 191, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lễ hội");
		lblNewLabel_4.setBounds(39, 54, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Triều đại");
		lblNewLabel_5.setBounds(39, 102, 191, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Di tích");
		lblNewLabel_6.setBounds(39, 127, 191, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sự kiện");
		lblNewLabel_7.setBounds(39, 154, 191, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Scrape");
		btnNewButton_3.addActionListener(new ActionListener() {
			private ArrayList<hisfigu> list;

			public void actionPerformed(ActionEvent e) {
				scrapHistoryfi scrapHistoryfi=new scrapHistoryfi();
				try {
					scrapHistoryfi.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list=scrapHistoryfi.list;
				GUI_HistoriFi gui_Historifi=new GUI_HistoriFi();
				try {
					gui_Historifi.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(239, 73, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Scrape");
		btnNewButton_4.setBounds(239, 98, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Scrape");
		btnNewButton_5.addActionListener(new ActionListener() {
			private ArrayList<historicalplace> list;
			public void actionPerformed(ActionEvent e) {
				scrapHistoricalplace scrapHistoricalplace=new scrapHistoricalplace();
				try {
					scrapHistoricalplace.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list=scrapHistoricalplace.list;
				GUI_HistoricalPlace gui_HistoricalPlace=new GUI_HistoricalPlace();
				try {
					gui_HistoricalPlace.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(239, 123, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Scrape");
		btnNewButton_6.addActionListener(new ActionListener() {
			private ArrayList<eventhistory> list;
			public void actionPerformed(ActionEvent e) {
				scrapEventhistory scrapEventhistory=new scrapEventhistory();
				try {
					scrapEventhistory.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list=scrapEventhistory.list;
				GUI_EventHistory gui_EventHistory=new GUI_EventHistory();
				try {
					gui_EventHistory.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(239, 150, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Save data");
		btnNewButton_7.addActionListener(new ActionListener() {
			//private ArrayList<hisfigu> list;
			public void actionPerformed(ActionEvent e) {
				scrapHistoryfi scrapHistoryfi = new scrapHistoryfi();
		    	try {
					scrapHistoryfi.run();
					scrapHistoryfi.saveJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	//list = scrapFestival.list;
		    	
			}
		});
		btnNewButton_7.setBounds(338, 73, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Save data");
		btnNewButton_8.setBounds(338, 98, 89, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Save data");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrapHistoricalplace scrapHistoricalplace = new scrapHistoricalplace();
		    	try {
					scrapHistoricalplace.run();
					scrapHistoricalplace.saveJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	//list = scrapFestival.list;
		    	
			}
		});
		btnNewButton_9.setBounds(338, 123, 89, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Save data");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrapEventhistory scrapEventhistory = new scrapEventhistory();
		    	try {
					scrapEventhistory.run();
					scrapEventhistory.saveJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	//list = scrapFestival.list;
		    	
			}
		});
		btnNewButton_10.setBounds(338, 150, 89, 23);
		contentPane.add(btnNewButton_10);
	}
}
