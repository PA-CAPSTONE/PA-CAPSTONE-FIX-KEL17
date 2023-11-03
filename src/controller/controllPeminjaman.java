package controller;
import model.modelPeminjaman;
import database.koneksi;
import java.sql.*;
import implement.implementPeminjaman;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class controllPeminjaman implements implementPeminjaman{
    Connection connection;
    final String create = "INSERT INTO peminjaman (Id, tgl_Peminjaman, Catatan) VALUES (?,?,?);";
    final String update = "UPDATE peminjaman set tgl_Peminjaman=?, Catatan=? WHERE Id=?;";
    final String delete = "DELETE FROM peminjaman where Id=?;";
    final String select = "SELECT * FROM peminjaman;";
    final String caripeminjaman = "SELECT * FROM peminjaman where Id like ?";
    
    
    public controllPeminjaman() {
        connection = koneksi.configDB();
    }
    
    
//    method update
    @Override
    public void update(modelPeminjaman x) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, x.gettgl_Peminjaman());
            statement.setString(2, x.getCatatan());
            statement.setString(3, x.getId());
            
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
    
    
//    CREATE
    @Override
    public void create(modelPeminjaman x){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);
            statement.setString(1, x.getId());
            statement.setString(2, x.gettgl_Peminjaman());
            statement.setString(3, x.getCatatan());
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
    public void delete (String Id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, Id);
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
    public List<modelPeminjaman> getAllPeminjaman() {
        List<modelPeminjaman> lb = null;
        try {
            lb = new ArrayList<modelPeminjaman>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                modelPeminjaman x = new modelPeminjaman();
                x.setId(rs.getString("Id"));
                x.setTgl_Peminjaman(rs.getString("tgl_Peminjaman"));
                x.setCatatan(rs.getString("Catatan"));
                lb.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(controllPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
    
//    method find
    @Override
    public List<modelPeminjaman> getcari (String Id) {
        List<modelPeminjaman> lb = null;
        try{
            lb = new ArrayList<modelPeminjaman>();
            PreparedStatement st = connection.prepareStatement(caripeminjaman);
            st.setString(1,"%" + Id + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                modelPeminjaman mp = new modelPeminjaman();
                mp.setId(rs.getString("Id"));
                mp.setTgl_Peminjaman(rs.getString("tgl_Peminjaman"));
                mp.setCatatan(rs.getString("Catatan"));
                lb.add(mp);
            }
        }catch (SQLException ex) {
            Logger.getLogger(controllPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}
