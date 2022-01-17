/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.persistence;
import regisresq.application.*; // Needed for the domain classes
import java.sql.Connection; // Needed to establish a DB connection
import java.sql.DriverManager; // Needed to connect to the DB server
import java.sql.ResultSet; // Needed to store the result of a SQL query
import java.sql.Statement; // Needed to create a SQL query
import java.sql.SQLException; // All DB ops must be in try-catch blocks
import java.util.*; // Needed for the ArrayList ADT


/**
 *
 * @author Coby Zimmerman
 */
public class AnimalDao implements Dao<Animal> {
    private List<Animal> animals;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    //ArrayList animals;

    public AnimalDao() {
        this.animals = new ArrayList<Animal>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/animals", "cs444", "p@sswordCS444");
        }
        catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }
        catch (SQLException er) {
            System.err.println("SQLException: " + er.getMessage());
        }
    }
    
    @Override
    public List<Animal> getAll() {
        Animal a = null;
        boolean isSterilized;
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from adoptable_pets;");
            
            while (resultSet.next()) {
                if (resultSet.getString("sterilized").equals("1")) {
                    isSterilized = true;
                } 
                else {
                    isSterilized = false;
                }
                
                if (resultSet.getString("type").equals("cat")) {
                    a = new Cat(resultSet.getString("breed"), 
                            resultSet.getString("name"), isSterilized,
                            resultSet.getString("arrived"));
                }
                else {
                    if (resultSet.getString("type").equals("dog")) {
                        a = new Dog(resultSet.getString("breed"), 
                                resultSet.getString("name"), isSterilized, 
                                resultSet.getString("arrived"));
                    }
                }
                animals.add(a);
            }
        }
        catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        
        //System.out.println(animals);
        return animals;
    }

    @Override
    public Boolean add(Animal a) {
        String type = null;
        
        try {
            statement = connection.createStatement();
            if (a.getSpecies().equals("dog")) {
                type = "dog";
            }
            else {
                if (a.getSpecies().contains("cat")) {
                    type = "cat";
                }
            }
            
            statement.execute("insert into adoptable_pets (type, breed, name, "
                    + "sterilized, arrived) values ('" + type + "', '" + a.getBreed() + 
                    "', '" + a.getName() + "', " + String.valueOf(a.isSterilized()) + ", '" 
                    + a.getDateArrived() + "');");
            return true;
        }
        catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean update(Animal a) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("update adoptable_pets set type = '" + 
                    a.getSpecies() + "', breed = '" + a.getBreed() + "', "
                    + "sterilized = " + String.valueOf(a.isSterilized()) + ", "
                    + "arrived = '" + a.getDateArrived() + "' where name = '" + 
                    a.getName() + "';");
            return true;
        }
        catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean delete(Animal a) {
        try {
            statement = connection.createStatement();
            statement.execute("delete from adoptable_pets where name = '" + 
                    a.getName() + "';");
            return true;
        }
        catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            return false;
        }
    }
}
