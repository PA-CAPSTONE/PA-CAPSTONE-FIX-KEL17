/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabelpeminjaman extends AbstractTableModel {
    List<modelPeminjaman> listPeminjaman;
    
    public modeltabelpeminjaman (List<modelPeminjaman> listPeminjaman) {
        this.listPeminjaman = listPeminjaman;
    }
    @Override
    public int getRowCount() {
        return listPeminjaman.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName (int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Tanggal Peminjaman";
            case 2:
                return "Catatan";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt (int row, int column) {
        switch (column) {
            case 0:
                return listPeminjaman.get(row).getId();
            case 1:
                return listPeminjaman.get(row).gettgl_Peminjaman();
            case 2:
                return listPeminjaman.get(row).getCatatan();
            default:
                return null;
        }
    }
    
}
