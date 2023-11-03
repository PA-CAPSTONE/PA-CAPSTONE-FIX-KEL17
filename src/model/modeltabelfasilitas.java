/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabelfasilitas extends AbstractTableModel {
    List<modelFasilitas> listFasilitas;
    
    public modeltabelfasilitas (List<modelFasilitas> listFasilitas) {
        this.listFasilitas = listFasilitas;
    }
    
    public int getRowCount() {
        return listFasilitas.size();
    }
    
    public int getColumnCount() {
        return 5;
    }
    
    public String getColumnName (int column) {
        switch (column) {
            case 0:
                return "id fasilitas";
            case 1:
                return "jenis fasilitas";
            case 2:
                return "nama fasilitas";
            case 3:
                return "kapasitas max";
            case 4:
                return "status ketersediaan";
            default:
                return null;
        }
    }
    
    public Object getValueAt (int row, int column) {
        switch (column) {
            case 0:
                return listFasilitas.get(row).getId_fasilitas();
            case 1:
                return listFasilitas.get(row).getJenis_fasilitas();
            case 2:
                return listFasilitas.get(row).getNama_fasilitas();
            case 3:
                return listFasilitas.get(row).getKapasitas_Max();
            case 4:
                return listFasilitas.get(row).getStatus_Ketersediaan();
            default:
                return null;
        }
    }
}
