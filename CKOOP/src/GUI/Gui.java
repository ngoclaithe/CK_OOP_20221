package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import allc.dynasty;
import allc.eventhistory;
import allc.festival;
import allc.hisfigu;
import allc.historicalplace;
import scrap.deleteJson;
import scrap.scrapDynasty;
import scrap.scrapEventhistory;
import scrap.scrapFestival;
import scrap.scrapHistoricalplace;
import scrap.scrapHistoryfi;
import scrap.search;
import scrap.tilesokhop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cạo Dữ Liệu Tự Động");
		lblNewLabel.setBounds(39, 28, 191, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Scrape");
		btnNewButton.addActionListener(new ActionListener() {
			

			

			public void actionPerformed(ActionEvent e) {
				scrapFestival scrapFestival = new scrapFestival();
		    	try {
					scrapFestival.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	list1 = scrapFestival.list;
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
		lblNewLabel_2.setBounds(39, 206, 191, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String stringsearch=textField.getText();
				search search=new search();
				stringsearch=search.convertStringToUnsigned(stringsearch);
				tilesokhop tilesokhop=new tilesokhop();
				
				double[] in_1=new double[list1.size()];
				double[] in_2=new double[list2.size()];
				double[] in_3=new double[list3.size()];
				double[] in_4=new double[list4.size()];
				double[] in_5=new double[list5.size()];
				String[] stringname1= new String[list1.size()];
				String[] stringname2= new String[list2.size()];
				String[] stringname3= new String[list3.size()];
				String[] stringname4= new String[list4.size()];
				String[] stringname5= new String[list5.size()];
				for(int i=0;i<list1.size();i++)
				{				
				stringname1[i]=list1.get(i).getName();				
				stringname1[i]=search.convertStringToUnsigned(stringname1[i]);
				in_1[i]=tilesokhop.similarity(stringsearch, stringname1[i]);				
				}				
				for(int i=0;i<list2.size();i++)
				{				
				stringname2[i]=list2.get(i).getName();				
				stringname2[i]=search.convertStringToUnsigned(stringname2[i]);
				in_2[i]=tilesokhop.similarity(stringsearch, stringname2[i]);
				}
				for(int i=0;i<list3.size();i++)
				{				
				stringname3[i]=list3.get(i).getNamedynasty();				
				stringname3[i]=search.convertStringToUnsigned(stringname3[i]);
				in_3[i]=tilesokhop.similarity(stringsearch, stringname3[i]);
				}
				for(int i=0;i<list4.size();i++)
				{				
				stringname4[i]=list4.get(i).getContent();				
				stringname4[i]=search.convertStringToUnsigned(stringname4[i]);
				in_4[i]=tilesokhop.similarity(stringsearch, stringname4[i]);
				}
				for(int i=0;i<list5.size();i++)
				{				
				stringname5[i]=list5.get(i).getName();				
				stringname5[i]=search.convertStringToUnsigned(stringname5[i]);
				in_5[i]=tilesokhop.similarity(stringsearch, stringname5[i]);
				}
				int chiso1=search.getIndexOfLargest(in_1);
				int chiso2=search.getIndexOfLargest(in_2);
				int chiso3=search.getIndexOfLargest(in_3);
				int chiso4=search.getIndexOfLargest(in_4);
				int chiso5=search.getIndexOfLargest(in_5);
				System.out.println("Thông tin tìm được:"+list1.get(chiso1).getName()+","+list1.get(chiso1).getHistoryfi()+","+list1.get(chiso1).getPlace()+","+list1.get(chiso1).getTime());
				System.out.println("Thông tin tìm được:"+list2.get(chiso2).getName()+","+list2.get(chiso2).getDes()+","+list2.get(chiso2).getRealname());
				System.out.println("Thông tin tìm được:"+list3.get(chiso3).getNamedynasty()+","+list3.get(chiso3).getTimefrom()+","+list3.get(chiso3).getTimeend());
				System.out.println("Thông tin tìm được:"+list4.get(chiso4).getContent()+","+list4.get(chiso4).getTime());
				System.out.println("Thông tin tìm được:"+list5.get(chiso5).getName()+","+list5.get(chiso5).getPlace());
			}
		});
		btnNewButton_2.setBounds(282, 230, 89, 23);
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
			

			public void actionPerformed(ActionEvent e) {
				scrapHistoryfi scrapHistoryfi=new scrapHistoryfi();
				try {
					scrapHistoryfi.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list2=scrapHistoryfi.list;
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
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				scrapDynasty scrapDynasty = new scrapDynasty();
		    	try {
					scrapDynasty.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	list3 = scrapDynasty.list;
		    	GUI_Dynasty gui_Dynasty=new GUI_Dynasty();
		    	try {
					gui_Dynasty.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(239, 98, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Scrape");
		btnNewButton_5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				scrapHistoricalplace scrapHistoricalplace=new scrapHistoricalplace();
				try {
					scrapHistoricalplace.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list5=scrapHistoricalplace.list;
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

			public void actionPerformed(ActionEvent e) {
				scrapEventhistory scrapEventhistory=new scrapEventhistory();
				try {
					scrapEventhistory.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				list4=scrapEventhistory.list;
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
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrapDynasty scrapDynasty = new scrapDynasty();
		    	try {
					scrapDynasty.run();
					scrapDynasty.saveJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	//list = scrapFestival.list;
		    	
			}
		});
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
		
		JLabel lblNewLabel_1 = new JLabel("Xóa data");
		lblNewLabel_1.setBounds(39, 181, 191, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_11 = new JButton("Delete All");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteJson deleteJson=new deleteJson();
				deleteJson.run();
				JOptionPane.showMessageDialog(null, "Đã xóa data json",
		                  "Title", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_11.setBounds(282, 184, 89, 23);
		contentPane.add(btnNewButton_11);
		
		textField = new JTextField();
		textField.setBounds(39, 222, 198, 38);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public static ArrayList<festival> list1;
	public static ArrayList<hisfigu> list2;
	public static ArrayList<dynasty> list3;
	public static ArrayList<eventhistory> list4;
	public static ArrayList<historicalplace> list5;
}
