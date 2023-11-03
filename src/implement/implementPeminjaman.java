/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implement;
import model.modelPeminjaman;

public interface implementPeminjaman {
    public void create(modelPeminjaman x);
    public void update(modelPeminjaman x);
    public void delete(String ID);
    
    public java.util.List<modelPeminjaman> getAllPeminjaman();
    public java.util.List<modelPeminjaman> getcari (String Id);
    
}
