
import java.awt.Color;
import java.awt.Component;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TableCellRenderer implements javax.swing.table.TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
       Messung m = (Messung)value; 
       JLabel label = new JLabel();
       
       JLabel h = new JLabel();
       
       label.setOpaque(true);
       
       DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
       
       if(isSelected)
           label.setBackground(Color.lightGray);
       else
           label.setBackground(h.getBackground());
       
       
       switch(column)
       {
           case 0: 
           {
               label.setText(m.getDate().format(df));
           }break;
           case 1:
           {
               label.setText(m.getTime().format(tf));
           }break;
           case 2:
           {
               label.setText(m.getKennzeichen());
           }break;
           case 3:
           {
               label.setText(""+m.getGemessen());
           }break;
           case 4:
           {
               label.setText(""+m.getErlaubt());
           }break;
           case 5:
           {
               label.setText(""+m.getUebertretung());
               
               if(m.getUebertretung() > 0 && m.getUebertretung() <= 10)
                   label.setBackground(Color.BLUE);
               else if(m.getUebertretung() > 10 && m.getUebertretung() <= 20)
                   label.setBackground(Color.yellow);
               else if(m.getUebertretung() > 20 && m.getUebertretung() <= 30)
                   label.setBackground(Color.orange);
               else if(m.getUebertretung() > 30)
                   label.setBackground(Color.red);
           }
           
       }
        
        return label;
    }
    
}
