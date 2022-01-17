/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.persistence;
import java.util.*;

/**
 *
 * @author Coby Zimmerman
 * @param <T>
 */
public interface Dao<T> {
    List<T> getAll();
    
    Boolean add(T item);
    
    Boolean update(T item);
    
    Boolean delete(T item);
}
