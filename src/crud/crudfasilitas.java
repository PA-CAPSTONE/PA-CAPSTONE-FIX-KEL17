package crud;
import controller.controllFasilitas;
import implement.implementFasilitas;
import model.modelFasilitas;
import java.util.List;
import gui.fasilitas;
import model.modeltabelfasilitas;
import javax.swing.JOptionPane;

public class crudfasilitas {
    fasilitas frameMenus;
    implementFasilitas Implementfasilitas;
    List<modelFasilitas> listfasilitas;
    
    public crudfasilitas(fasilitas frameMenu) {
        this.frameMenus = frameMenu;
        Implementfasilitas = new controllFasilitas();
        listfasilitas = Implementfasilitas.getAll();
    }
    
    public void reset() {
        frameMenus.getTxtId().setText("");
        frameMenus.getcbjenis().setSelectedItem("---jenis fasilitas---");
        frameMenus.getnamatxt().setText("");
        frameMenus.getkapasitastxt().setText("");
        frameMenus.getcbstatus().setSelectedItem("---ketersedian---");
    }
    
    public void isitable() {
        listfasilitas = Implementfasilitas.getAll();
        modeltabelfasilitas mtf = new modeltabelfasilitas (listfasilitas);
        frameMenus.getTabelFasilitas().setModel(mtf);
    }
    
    public void isiField(int row) {
        frameMenus.getTxtId().setText(listfasilitas.get(row).getId_fasilitas());
        frameMenus.getcbjenis().setSelectedItem(listfasilitas.get(row).getJenis_fasilitas());
        frameMenus.getnamatxt().setText(listfasilitas.get(row).getNama_fasilitas());
        frameMenus.getkapasitastxt().setText(listfasilitas.get(row).getKapasitas_Max());
        frameMenus.getcbstatus().setSelectedItem(listfasilitas.get(row).getStatus_Ketersediaan());
    }   
    
    public void create() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()&!frameMenus.getnamatxt().getText().trim().isEmpty()&!frameMenus.getkapasitastxt().getText().trim().isEmpty()){
            modelFasilitas mf = new modelFasilitas();
            mf.setId_fasilitas(frameMenus.getTxtId().getText());
            mf.setJenis_fasilitas(frameMenus.getcbjenis().getSelectedItem().toString());
            mf.setNama_fasilitas(frameMenus.getnamatxt().getText());
            mf.setKapasitas_Max(frameMenus.getkapasitastxt().getText());
            mf.setStatus_Ketersediaan(frameMenus.getcbstatus().getSelectedItem().toString());
            
            Implementfasilitas.create(mf);
            JOptionPane.showMessageDialog(null, "Fasilitas berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(frameMenus, "data tidak boleh kosong");
        }
    }
    
    public void update() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()){
            modelFasilitas mf = new modelFasilitas();
            mf.setId_fasilitas (frameMenus.getTxtId().getText());
            mf.setJenis_fasilitas(frameMenus.getcbjenis().getSelectedItem().toString());
            mf.setNama_fasilitas(frameMenus.getnamatxt().getText());
            mf.setKapasitas_Max(frameMenus.getkapasitastxt().getText());
            mf.setStatus_Ketersediaan(frameMenus.getcbstatus().getSelectedItem().toString());
            Implementfasilitas.update(mf);
            JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        } else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang akan diupdate");
        }
    }
    
    public void delete() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()){
            String ID = (frameMenus.getTxtId().getText());
            Implementfasilitas.delete(ID);
        }else {
            JOptionPane.showMessageDialog(frameMenus,"Silahkan pilih data yang ingin dihapus");
        }   
    }
    
    public void isiTabelCariNama() {
        listfasilitas = Implementfasilitas.getcarinama(frameMenus.getsearchtxt().getText());
        modeltabelfasilitas mtf = new modeltabelfasilitas (listfasilitas);
        frameMenus.getTabelFasilitas().setModel(mtf);
    }
    
    public void cariNama() {
        if(!frameMenus.getTxtId().getText().trim().isEmpty()){
            Implementfasilitas.getcarinama(frameMenus.getsearchtxt().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frameMenus, "Silahkan Pilih Data!");
        }
    }
    
}
