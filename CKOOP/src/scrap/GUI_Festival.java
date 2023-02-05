package scrap;

import java.io.IOException;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;

import scrap.scrapFestival;
import allc.festival;


public class GUI_Festival extends JFrame {

    public GUI_Festival() {
        initComponents();
        //addRowToJTable();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên lễ hội", "Thời gian", "Địa điểm", "Nhân Vật liên quan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }                        

    public static void run() throws IOException {
    	
    	scrapFestival scrapFestival = new scrapFestival();
    	scrapFestival.run();
    	list = scrapFestival.list;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Festival().setVisible(true);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Object rowData[] = new Object[4];
                for(int i = 0; i < list.size(); i++)
                {
                    rowData[0] = list.get(i).getName();
                    rowData[1] = list.get(i).getTime();
                    rowData[2] = list.get(i).getPlace();
                    rowData[3] = list.get(i).getHistoryfi();
                    model.addRow(rowData);
                }
            }
        }
        
        )
        
        ;
    }             
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
	private static ArrayList<festival> list;                
}