/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.presentation;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import regisresq.application.*;
import regisresq.persistence.*;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author cobyz
 */
public class MainUI extends javax.swing.JFrame {
    //Assign 5 attribute additions
    private List<Animal> animals = null;
    private AnimalTableModel model = new AnimalTableModel();
    private int selectedRow = -1;
    private final Dao database = new AnimalDao();
    
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        
        // Table row and column changes
        animalsTbl.setAutoCreateRowSorter(true);
        animalsTbl.getColumnModel().getColumn(0).setPreferredWidth(75);
        animalsTbl.getColumnModel().getColumn(1).setPreferredWidth(75);
        animalsTbl.getColumnModel().getColumn(2).setPreferredWidth(75);
        animalsTbl.getColumnModel().getColumn(3).setPreferredWidth(75);
        animalsTbl.getColumnModel().getColumn(4).setPreferredWidth(75);
        
        //mnemonics for labels
        nameLbl.setDisplayedMnemonic('n');
        nameLbl.setLabelFor(nameTxtFld);
        breedLbl.setDisplayedMnemonic('b');
        breedLbl.setLabelFor(breedTxtFld);
        arrivalLbl.setDisplayedMnemonic('r');
        arrivalLbl.setLabelFor(arrivalTxtFldMnth);
        typeLbl.setDisplayedMnemonic('t');
        typeLbl.setLabelFor(typeCombo);
        sterilizedLbl.setDisplayedMnemonic('s');
        sterilizedLbl.setLabelFor(sterilizedCombo);
        
        //mnemonics for buttons/menu items
        exitMenuItem.setMnemonic('e');
        fileMenuItem.setMnemonic('f');
        addBttn.setMnemonic('a');
        clearBttn.setMnemonic('c');
        modifyBttn.setMnemonic('m');
        deleteBttn.setMnemonic('d');
        exitBttn.setMnemonic('x');
        
        //focus listeners
        arrivalTxtFldMnth.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (arrivalTxtFldMnth.getText().equals("MM"))
                arrivalTxtFldMnth.selectAll();
            }
            
            @Override
            public void focusLost(FocusEvent arg0) {
                
            }
        });
        
        arrivalTxtFldDay.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (arrivalTxtFldDay.getText().equals("DD"))
                arrivalTxtFldDay.selectAll();
            }
            
            @Override
            public void focusLost(FocusEvent arg0) {
                
            }
        });
        
        arrivalTxtFldYear.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (arrivalTxtFldYear.getText().equals("YYYY"))
                arrivalTxtFldYear.selectAll();
            }
            
            @Override
            public void focusLost(FocusEvent arg0) {
                
            }
        });
        
        //Assign 5 additions to put contents of database into table and indicate
        //update display
        animals = database.getAll();
        model.setAnimals(animals);
        animalsTbl.setModel(model);
        model.fireTableDataChanged();
        
        //Click one cell in table will highlight entire row
        animalsTbl.setColumnSelectionAllowed(false);
        animalsTbl.setRowSelectionAllowed(true);
        
        //Code to populate text data from data in table rows
        animalsTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String date;
                String month, day, year;
                int row = animalsTbl.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    selectedRow = row;
                    breedTxtFld.setText(model.getValueAt(row, 1).toString());
                    nameTxtFld.setText(model.getValueAt(row, 2).toString());
                    date = model.getValueAt(row, 4).toString();
                    arrivalTxtFldYear.setText(date.split("-")[0]);
                    arrivalTxtFldMnth.setText(date.split("-")[1]);
                    arrivalTxtFldDay.setText(date.split("-")[2]);
                    
                    //for comboboxes
                    if (model.getValueAt(row, 0).toString().equals("dog")) {
                        typeCombo.setSelectedIndex(0);
                    }
                    else {
                        typeCombo.setSelectedIndex(1);
                    }
                    
                    if (model.getValueAt(row, 3).toString().equals("true")) {
                        sterilizedCombo.setSelectedIndex(0);
                    }
                    else {
                        sterilizedCombo.setSelectedIndex(1);
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        animalsTbl = new javax.swing.JTable();
        nameLbl = new javax.swing.JLabel();
        breedLbl = new javax.swing.JLabel();
        arrivalLbl = new javax.swing.JLabel();
        typeLbl = new javax.swing.JLabel();
        sterilizedLbl = new javax.swing.JLabel();
        nameTxtFld = new javax.swing.JTextField();
        breedTxtFld = new javax.swing.JTextField();
        arrivalTxtFldMnth = new javax.swing.JTextField();
        arrivalTxtFldDay = new javax.swing.JTextField();
        arrivalTxtFldYear = new javax.swing.JTextField();
        typeCombo = new javax.swing.JComboBox();
        sterilizedCombo = new javax.swing.JComboBox();
        clearBttn = new javax.swing.JButton();
        addBttn = new javax.swing.JButton();
        modifyBttn = new javax.swing.JButton();
        deleteBttn = new javax.swing.JButton();
        exitBttn = new javax.swing.JButton();
        fileMenu = new javax.swing.JMenuBar();
        fileMenuItem = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jFrame1.setTitle("Regis ResQ");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regis ResQ");

        animalsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Type", "Breed", "Name", "Sterilized", "Arrived"
            }
        ));
        jScrollPane1.setViewportView(animalsTbl);

        nameLbl.setText("Name");

        breedLbl.setText("Breed");

        arrivalLbl.setText("Arrival Date");

        typeLbl.setText("Type of Animal");

        sterilizedLbl.setText("Spayed/Neutered");

        arrivalTxtFldMnth.setForeground(new java.awt.Color(153, 153, 153));
        arrivalTxtFldMnth.setText("MM");

        arrivalTxtFldDay.setForeground(new java.awt.Color(153, 153, 153));
        arrivalTxtFldDay.setText("DD");

        arrivalTxtFldYear.setForeground(new java.awt.Color(153, 153, 153));
        arrivalTxtFldYear.setText("YYYY");

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dog", "Cat" }));

        sterilizedCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        clearBttn.setText("Clear");
        clearBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBttnActionPerformed(evt);
            }
        });

        addBttn.setText("Add");
        addBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBttnActionPerformed(evt);
            }
        });

        modifyBttn.setText("Modify");
        modifyBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBttnActionPerformed(evt);
            }
        });

        deleteBttn.setText("Delete");
        deleteBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBttnActionPerformed(evt);
            }
        });

        exitBttn.setText("Exit");
        exitBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBttnActionPerformed(evt);
            }
        });

        fileMenuItem.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenuItem.add(exitMenuItem);

        fileMenu.add(fileMenuItem);

        setJMenuBar(fileMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLbl)
                            .addComponent(breedLbl)
                            .addComponent(arrivalLbl)
                            .addComponent(typeLbl)
                            .addComponent(sterilizedLbl))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sterilizedCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTxtFld)
                                    .addComponent(breedTxtFld)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(arrivalTxtFldMnth, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(arrivalTxtFldDay, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(arrivalTxtFldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(clearBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exitBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(breedLbl)
                    .addComponent(breedTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arrivalLbl)
                    .addComponent(arrivalTxtFldMnth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivalTxtFldDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivalTxtFldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBttn))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLbl)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sterilizedLbl)
                    .addComponent(sterilizedCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBttn)
                    .addComponent(modifyBttn)
                    .addComponent(deleteBttn)
                    .addComponent(exitBttn))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBttnActionPerformed
        Animal a;
        String date;
        Boolean sterilizedValue;
        
        //set date and sterilized value to what is put in text fields/combobox
        date = arrivalTxtFldYear.getText() + "-" + arrivalTxtFldMnth.getText()
                + "-" + arrivalTxtFldDay.getText();
        sterilizedValue = (Boolean)(sterilizedCombo.getSelectedItem()
                .toString().equals("Yes"));
        
        if (typeCombo.getSelectedItem().toString().equals("Dog")) {
            a = new Dog(breedTxtFld.getText(), nameTxtFld.getText(), 
                    sterilizedValue, date);
        }
        else {
            a = new Cat(breedTxtFld.getText(), nameTxtFld.getText(), 
                    sterilizedValue, date);
        }
        //validate method error message if fields are invalid
        if (!a.validate()) {
            JOptionPane.showMessageDialog(null, "Could not validate certain "
                    + "fields, check if any values are incorrect");
            return;
        }
        //error if add to database failed
        if (!database.add(a)) {
            JOptionPane.showMessageDialog(null, "Could not add new animal "
                    + "object to database");
            return;
        }
        
        animals.add(a);
        selectedRow = -1;
        model.setAnimals(animals);
        model.fireTableDataChanged();
        
        //reset text fields to empty or default
        nameTxtFld.setText("");
        breedTxtFld.setText("");
        arrivalTxtFldYear.setText("YYYY");
        arrivalTxtFldMnth.setText("MM");
        arrivalTxtFldDay.setText("DD");
        
        //reset combo box default value
        typeCombo.setSelectedIndex(0);
        sterilizedCombo.setSelectedIndex(0);
        
    }//GEN-LAST:event_addBttnActionPerformed

    private void modifyBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBttnActionPerformed
        if (selectedRow < 0) {
            return;
        }
        
        Animal a;
        String date;
        Boolean sterilizedValue;
        
        a = animals.get(selectedRow);
        a.setBreed(breedTxtFld.getText());
        a.setName(nameTxtFld.getText());
        
        date = arrivalTxtFldYear.getText() + "-" + arrivalTxtFldMnth.getText()
                + "-" + arrivalTxtFldDay.getText();
        sterilizedValue = (Boolean)(sterilizedCombo.getSelectedItem().toString()
                .equals("Yes"));
        
        a.setDateArrived(date);
        a.setSterilized(sterilizedValue);
        
        if (!a.validate()) {
            JOptionPane.showMessageDialog(null, "Could not validate certain"
                    + " fields, check if any values are incorrect");
            return;
        }
        
        if (!database.update(a)) {
            JOptionPane.showMessageDialog(null, "Could not add new animal "
                    + "object to database");
            return;
        }
        
        selectedRow = -1;
        model.fireTableDataChanged();
        nameTxtFld.setText("");
        breedTxtFld.setText("");
        arrivalTxtFldYear.setText("YYYY");
        arrivalTxtFldMnth.setText("MM");
        arrivalTxtFldDay.setText("DD");
        typeCombo.setSelectedIndex(0);
        sterilizedCombo.setSelectedIndex(0);
    }//GEN-LAST:event_modifyBttnActionPerformed

    private void deleteBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBttnActionPerformed
        if (selectedRow < 0) {
            return;
        }
        
        int selectedOption;
        Animal a;
        
        a = animals.get(selectedRow);
        
        selectedOption = JOptionPane.showConfirmDialog(null, 
                "Delete the selected row?", "Yes/No", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            animals.remove(selectedRow);
            model.fireTableDataChanged();
            database.delete(a);
            selectedRow = -1;
            nameTxtFld.setText("");
            breedTxtFld.setText("");
            arrivalTxtFldYear.setText("YYYY");
            arrivalTxtFldMnth.setText("MM");
            arrivalTxtFldDay.setText("DD");
            typeCombo.setSelectedIndex(0);
            sterilizedCombo.setSelectedIndex(0);
        }
    }//GEN-LAST:event_deleteBttnActionPerformed

    private void clearBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBttnActionPerformed
        nameTxtFld.setText("");
        breedTxtFld.setText("");
        arrivalTxtFldYear.setText("YYYY");
        arrivalTxtFldMnth.setText("MM");
        arrivalTxtFldDay.setText("DD");
    }//GEN-LAST:event_clearBttnActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void exitBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBttnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBttnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBttn;
    private javax.swing.JTable animalsTbl;
    private javax.swing.JLabel arrivalLbl;
    private javax.swing.JTextField arrivalTxtFldDay;
    private javax.swing.JTextField arrivalTxtFldMnth;
    private javax.swing.JTextField arrivalTxtFldYear;
    private javax.swing.JLabel breedLbl;
    private javax.swing.JTextField breedTxtFld;
    private javax.swing.JButton clearBttn;
    private javax.swing.JButton deleteBttn;
    private javax.swing.JButton exitBttn;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuBar fileMenu;
    private javax.swing.JMenu fileMenuItem;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBttn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxtFld;
    private javax.swing.JComboBox sterilizedCombo;
    private javax.swing.JLabel sterilizedLbl;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration//GEN-END:variables

}