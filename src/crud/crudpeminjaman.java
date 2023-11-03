
package crud;
import controller.controllPeminjaman;
import implement.implementPeminjaman;
import model.modelPeminjaman;
import java.util.List;
import gui.peminjaman;
import model.modeltabelpeminjaman;
import javax.swing.JOptionPane;

public class crudpeminjaman {
    peminjaman frameMenus;
    implementPeminjaman Implementpeminjaman; 
    List<modelPeminjaman> listpeminjaman;
    
    public crudpeminjaman(peminjaman frameMenu) {
        this.frameMenus = frameMenu;
        Implementpeminjaman = new controllPeminjaman(); 
        listpeminjaman = Implementpeminjaman.getAllPeminjaman();
    }
    
    public void reset() {
        frameMenus.getTxtId().setText("");
        frameMenus.getTglWaktuFormat().setText("");
        frameMenus.getCatatantxt().setText("");
    }
    
    public void isitable() {
        listpeminjaman = Implementpeminjaman.getAllPeminjaman();
        modeltabelpeminjaman mtp = new modeltabelpeminjaman (listpeminjaman);
        frameMenus.getModeltabelpeminjaman().setModel(mtp);
    }
    
    public void isiField(int row) {
        frameMenus.getTxtId().setText(listpeminjaman.get(row).getId());
        frameMenus.getTglWaktuFormat().setText(listpeminjaman.get(row).gettgl_Peminjaman());
        frameMenus.getCatatantxt().setText(listpeminjaman.get(row).getCatatan());
    }
    
    public void create() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()&!frameMenus.getTglWaktuFormat().getText().trim().isEmpty()&!frameMenus.getCatatantxt().getText().trim().isEmpty()){
            modelPeminjaman mp = new modelPeminjaman();
            mp.setId(frameMenus.getTxtId().getText());
            mp.setTgl_Peminjaman(frameMenus.getTglWaktuFormat().getText());
            mp.setCatatan(frameMenus.getCatatantxt().getText());
            
            Implementpeminjaman.create(mp);
            JOptionPane.showMessageDialog(null, "Data Peminjaman berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(frameMenus, "data tidak boleh kosong");
        }
    }
    
    public void update() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()){
            modelPeminjaman mp = new modelPeminjaman();
            mp.setId (frameMenus.getTxtId().getText());
            mp.setTgl_Peminjaman(frameMenus.getTglWaktuFormat().getText());
            mp.setCatatan(frameMenus.getCatatantxt().getText());
            Implementpeminjaman.update(mp);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang akan diupdate");
        }
    }
        
    public void delete() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()){
            String ID = (frameMenus.getTxtId().getText());
            Implementpeminjaman.delete(ID);
        }else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang ingin dihapus");
        }
    }
    
    public void isiTabelCari(String id) {
        listpeminjaman = Implementpeminjaman.getcari(id);
        modeltabelpeminjaman mtp = new modeltabelpeminjaman (listpeminjaman);
        frameMenus.getModeltabelpeminjaman().setModel(mtp);
    }
    
    public void cariID(String id) {
        
            Implementpeminjaman.getcari(id);
            isiTabelCari(id);
     
    }
}
    

