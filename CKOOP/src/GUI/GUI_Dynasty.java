package GUI;
import java.io.IOException;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;

import scrap.scrapDynasty;
import allc.dynasty;


public class GUI_Dynasty extends JFrame {

    public GUI_Dynasty() {
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
                "Tên", "Bắt đầu", "Kết thúc"
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
    	
    	scrapDynasty scrapDynasty = new scrapDynasty();
    	scrapDynasty.run();
    	list = scrapDynasty.list;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Dynasty().setVisible(true);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                Object rowData[] = new Object[3];
                for(int i = 0; i < list.size(); i++)
                {
                    rowData[0] = list.get(i).getNamedynasty();
                    rowData[1] = list.get(i).getTimefrom();
                    rowData[2] = list.get(i).getTimeend();
//                    rowData[3] = list.get(i).getContent();
                    model.addRow(rowData);
                }
            }
        }
        
        )
        
        ;
    }             
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
	private static ArrayList<dynasty> list;                
}
