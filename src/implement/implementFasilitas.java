/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implement;
import model.modelFasilitas;


public interface implementFasilitas {
    public void create(modelFasilitas x);
    public void update(modelFasilitas x);
    public void delete(String ID);
    
    public java.util.List<modelFasilitas> getAll();
    public java.util.List<modelFasilitas> getcarinama (String namafasilitas);
    
}