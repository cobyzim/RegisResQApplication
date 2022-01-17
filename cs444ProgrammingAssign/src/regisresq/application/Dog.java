/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.application;

/**
 *
 * @author Coby Zimmerman
 */
public class Dog extends Animal {
    public Dog() {
        super();
        super.species = "dog";
        this.breed = null;
        this.name = null;
        this.sterilized = false;
        this.dateArrived = null;
    }
    
    public Dog(String breed, String name, boolean sterilized, String dateArrived) {
        super(breed, name, sterilized, dateArrived);
        super.species = "dog";
    }
}

