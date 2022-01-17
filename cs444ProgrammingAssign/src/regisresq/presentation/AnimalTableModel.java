/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.presentation;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import regisresq.application.Animal;

/**
 *
 * @author cobyz
 */
public class AnimalTableModel extends AbstractTableModel {
    //Assign 5 table model attributes
    private List<Animal> animals;
    private final String[] columnNames = {"Type", "Breed", "Name", "Sterilized",
                                          "Arrived"};
    
    //default constructor sets list to null
    public AnimalTableModel () {
        animals = null;
        
    }

    //setter with list argument
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    
    @Override
    public int getRowCount() {
        int listSize = animals.size();
        
        return listSize;
    }
    
    @Override
    public int getColumnCount() {
        int columnSize = columnNames.length;
        
        return columnSize;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Animal a;
        a = animals.get(row);
        
        switch (column) {
            case 0:
                return a.getSpecies();
            case 1:
                return a.getBreed();
            case 2:
                return a.getName();
            case 3:
                return a.isSterilized();
            case 4:
                return a.getDateArrived();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String columnName = columnNames[columnIndex];
        
        return columnName;
    }
    
}
