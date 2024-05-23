/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import DAOdataperpus.dataperpusDAO;
import model.*;
import view.MainView;
import DAOimplement.dataperpusimplement;
/**
 *
 * @author DELL
 */
public class dataperpuscontroller {
    MainView frame;
    dataperpusimplement impldataperpus;
    List<dataperpus> dp;
    int nilaiRating, nilaiHarga;
    final int perawatan = 500;
    String nilaiJudul, nilaiPenulis;
    
    public dataperpuscontroller(MainView frame){
        this.frame = frame;
        impldataperpus = new dataperpusDAO();
        dp = impldataperpus.getAll();
    }
    
    public void isitabel(){
        dp = impldataperpus.getAll();
        modeltabeldataperpus mp = new modeltabeldataperpus(dp);
        frame.getjTablePerpus().setModel(mp);
    }
    
    public void insert(){
        dataperpus dp = new dataperpus();
        nilaiHarga = Integer.parseInt(frame.getjTextHarga().getText());
        nilaiRating = Integer.parseInt(frame.getjTextRating().getText());
        
        nilaiHarga = nilaiHarga + perawatan + (nilaiRating * 100);
        
        nilaiJudul = frame.getjTextJudul().getText();
        nilaiPenulis = frame.getjTextPenulis().getText();
        
        dp.setJudul(nilaiJudul);
        dp.setPenulis(nilaiPenulis);
        dp.setRating(nilaiRating);
        dp.setHarga(nilaiHarga);
        impldataperpus.insert(dp);
    }
    
    public void update(){
        dataperpus dp = new dataperpus();
        nilaiHarga = Integer.parseInt(frame.getjTextHarga().getText());
        nilaiRating = Integer.parseInt(frame.getjTextRating().getText());
        
        nilaiHarga = nilaiHarga + perawatan + (nilaiRating * 100);
        
        nilaiJudul = frame.getjTextJudul().getText();
        nilaiPenulis = frame.getjTextPenulis().getText();
        
        dp.setJudul(nilaiJudul);
        dp.setPenulis(nilaiPenulis);
        dp.setRating(nilaiRating);
        dp.setHarga(nilaiHarga);
        impldataperpus.update(dp);
    }
    
    public void delete(){
        nilaiJudul = frame.getjTextJudul().getText();
        impldataperpus.delete(nilaiJudul);
    }
}
