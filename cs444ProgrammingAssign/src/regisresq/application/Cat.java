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
public class Cat extends Animal {
    public Cat() {
        super();
        super.species = "cat";
        this.breed = null;
        this.name = null;
        this.sterilized = false;
        this.dateArrived = null;
    }
    
    public Cat(String breed, String name, boolean sterilized, String dateArrived) {
        super(breed, name, sterilized, dateArrived);
        super.species = "cat";
    }
}
