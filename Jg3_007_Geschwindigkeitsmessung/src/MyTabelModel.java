
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MyTabelModel extends AbstractTableModel
{
    ArrayList<Messung> data = new ArrayList();
    private static final String[] COLNAMES = {"Datum", "Uhrzeit", "Kennzeichen", "Gemessen", "Erlaubt", "Überschreitung"};
    
    public void add(Messung m)
    {
        data.add(m);
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }
    
    void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Messung s : data) {
            oos.writeObject(s);
        }
    }
    
    void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object a = null;
        while ((a = ois.readObject()) != null) {
            add((Messung) a);
        }
}
    
    public void del(int idx)
    {
        data.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }
    
    public double getAvgUeber()
    {
        int avg = 0;
        
        for(Messung m : data)
        {
            avg+=m.getUebertretung();
        }
     
        return avg/data.size();
    }
            
    @Override
    public int getRowCount()
    {
        return data.size();
    }

    @Override
    public int getColumnCount()
    {
       return COLNAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return data.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int idx)
    {
        return COLNAMES[idx];
    }
    
   
    
}
