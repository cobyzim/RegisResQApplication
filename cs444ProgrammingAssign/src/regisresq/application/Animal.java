/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisresq.application;

/**
 *
 * @author Coby Zimmemrman
 * CS444
 * 
 */
public class Animal {
    protected String species;
    protected String breed;
    protected String name;
    protected boolean sterilized;
    protected String dateArrived;

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public String getDateArrived() {
        return dateArrived;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    @Override
    public String toString() {
        return "Animal{" + "species=" + species + ", breed=" + breed + ", name=" + name + ", sterilized=" + sterilized + ", dateArrived=" + dateArrived + '}';
    }

    public Animal() {
    }

    public Animal(String breed, String name, boolean sterilized, String dateArrived) {
        this.breed = breed;
        this.name = name;
        this.sterilized = sterilized;
        this.dateArrived = dateArrived;
    }
    
    public boolean validate() {
        if ((breed == null) || (breed.equals(""))) {
            return false;
        }
        if ((name == null) || (name.equals(""))) {
            return false;
        }
        if ((dateArrived == null) || (dateArrived.equals(""))) {
            return false;
        }
        if ((dateArrived.substring(0, 4).chars().allMatch(Character::isDigit)) 
                && (dateArrived.charAt(4) == '-')
                && (dateArrived.substring(5, 7).chars().allMatch(Character::isDigit))
                && (dateArrived.charAt(7) == '-')
                && (dateArrived.substring(8).chars().allMatch(Character::isDigit))) {
            String year = dateArrived.substring(0, 4);
            String month = dateArrived.substring(5, 7);
            String day = dateArrived.substring(8);
            
            switch (month) {
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    return (Integer.valueOf(day) <= 31);
                case "02":
                    return (Integer.valueOf(day) <= 29);
                case "04":
                case "06":
                case "09":
                case "11":
                    return (Integer.valueOf(day) <= 30);
                default:
                    return false;
            }
        }
        else {
            return false;
        }
    }
}


