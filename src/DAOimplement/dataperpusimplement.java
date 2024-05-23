/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import java.util.*;
import model.*;

/**
 *
 * @author DELL
 */
public interface dataperpusimplement {
    public void insert(dataperpus p);
    public void update(dataperpus p);
    public void delete(String judul);
    public List<dataperpus> getAll();
}
