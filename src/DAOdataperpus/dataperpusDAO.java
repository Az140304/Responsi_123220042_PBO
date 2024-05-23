/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataperpus;

import java.sql.*;
import java.util.*;
import konektor.connector;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOimplement.dataperpusimplement;

/**
 *
 * @author DELL
 */
public class dataperpusDAO implements dataperpusimplement {
    
    Connection connection;
    
    final String select = "SELECT * FROM buku";
    final String insert = "INSERT INTO  buku (judul, penulis, rating, harga) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE buku set judul=?, penulis=?, rating=?, harga=? where judul=?";
    final String delete = "DELETE FROM buku WHERE judul=?";
    
    public dataperpusDAO(){
        connection = connector.connection();
    } 
            
    @Override
    public void insert(dataperpus p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getPenulis());
            statement.setInt(3, p.getRating());
            statement.setInt(4, p.getHarga());
            statement.executeUpdate();
            
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(dataperpus p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getPenulis());
            statement.setInt(3, p.getRating());
            statement.setInt(4, p.getHarga());
            statement.setString(5, p.getJudul());
            statement.executeUpdate();
            
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
            
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<dataperpus> getAll() {
        List<dataperpus>dp = null;
        
        try {
            dp = new ArrayList<dataperpus>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            
            while(rs.next()){
                dataperpus pp = new dataperpus();
                pp.setJudul(rs.getString("judul"));
                pp.setPenulis(rs.getString("penulis"));
                pp.setRating(rs.getInt("rating"));
                pp.setHarga(rs.getInt("harga"));
                dp.add(pp);
            }
        } catch (SQLException ex){
            Logger.getLogger(dataperpusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dp;
    }
    
}
