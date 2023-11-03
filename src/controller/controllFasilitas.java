package controller;
import model.modelFasilitas;
import database.koneksi;
import java.sql.*;
import implement.implementFasilitas;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;


public class controllFasilitas implements implementFasilitas {
    Connection connection;
    final String create = "INSERT INTO fasilitas (Id_fasilitas, Jenis_fasilitas, Nama_fasilitas, Kapasitas_Max, Status_Ketersediaan) VALUES (?,?,?,?,?);";
    final String update = "UPDATE fasilitas set Jenis_fasilitas=?, Nama_fasilitas=?, Kapasitas_Max=?, Status_Ketersediaan=? WHERE Id_fasilitas=?;";
    final String delete = "DELETE FROM fasilitas where Id_fasilitas=?;";
    final String select = "SELECT * FROM fasilitas;";
    final String carifasilitas = "SELECT * FROM fasilitas where Nama_fasilitas like ?";
    
    
    public controllFasilitas() {
        connection = koneksi.configDB();
    }
    
//    CREATE
    @Override
    public void create(modelFasilitas x){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);
            statement.setString(1, x.getId_fasilitas());
            statement.setString(2, x.getJenis_fasilitas());
            statement.setString(3, x.getNama_fasilitas());
            statement.setString(4, x.getKapasitas_Max());
            statement.setString(5, x.getStatus_Ketersediaan());
            statement.executeUpdate();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
        
    
//    method find
    @Override
    public List<modelFasilitas> getcarinama (String Nama_fasilitas) {
        List<modelFasilitas> lb = null;
        try{
            lb = new ArrayList<modelFasilitas>();
            PreparedStatement st = connection.prepareStatement(carifasilitas);
            st.setString(1,"%" + Nama_fasilitas + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                modelFasilitas mf = new modelFasilitas();
                mf.setId_fasilitas(rs.getString("Id_fasilitas"));
                mf.setJenis_fasilitas(rs.getString("Jenis_fasilitas"));
                mf.setNama_fasilitas(rs.getString("Nama_fasilitas"));
                mf.setKapasitas_Max(rs.getString("Kapasitas_Max"));
                mf.setStatus_Ketersediaan(rs.getString("Status_Ketersediaan"));
                lb.add(mf);
            }
        }catch (SQLException ex) {
            Logger.getLogger(controllFasilitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
//    method update
    @Override
    public void update(modelFasilitas x) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, x.getJenis_fasilitas());
            statement.setString(2, x.getNama_fasilitas());
            statement.setString(3, x.getKapasitas_Max());
            statement.setString(4, x.getStatus_Ketersediaan());
            statement.setString(5, x.getId_fasilitas());
            statement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
//    method delete
    @Override
    public void delete (String Id_fasilitas) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, Id_fasilitas);
            statement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<modelFasilitas> getAll() {
        List<modelFasilitas> lb = null;
        try {
            lb = new ArrayList<modelFasilitas>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                modelFasilitas x = new modelFasilitas();
                x.setId_fasilitas(rs.getString("id_fasilitas"));
                x.setJenis_fasilitas(rs.getString("jenis_fasilitas"));
                x.setNama_fasilitas(rs.getString("Nama_fasilitas"));
                x.setKapasitas_Max(rs.getString("Kapasitas_Max"));
                x.setStatus_Ketersediaan(rs.getString("Status_Ketersediaan"));
                lb.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllFasilitas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
   
}
