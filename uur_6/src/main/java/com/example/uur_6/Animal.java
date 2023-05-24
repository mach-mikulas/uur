package com.example.uur_6;

import javafx.beans.property.*;
import java.time.*;

public class Animal {
    private DoubleProperty weight = new SimpleDoubleProperty();
    private StringProperty species = new SimpleStringProperty();
    private StringProperty sound = new SimpleStringProperty();
    private IntegerProperty legCount = new SimpleIntegerProperty();
    private ObjectProperty date = new SimpleObjectProperty<LocalDate>();
    private BooleanProperty alive = new SimpleBooleanProperty();



    public Animal(){

    }

    public Animal(double weigh, String species, String sound, int legCount) {
        this();

        this.setWeight(weigh);
        this.setSpecies(species);
        this.setSound(sound);
        this.setLegCount(legCount);
        this.setAlive(true);
        this.setDate(LocalDate.now());
    }

    public Animal(double weigh, String species, String sound, int legCount, LocalDate birthDate, boolean alive) {
        this(weigh, species,sound,legCount);

        this.setDate(birthDate);
        this.setAlive(alive);
    }

    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight > 0) {
            this.weight.set(weight);
        }
        else {
            throw new IllegalArgumentException("Váha musí být kladné nenulové číslo");
        }
    }

    public String getSpecies() {
        System.out.println("Getting species of " + species.get());
        return species.get();
    }

    public StringProperty speciesProperty() {
        System.out.println("Getting property species of " + species.get());
        return species;
    }

    public void setSpecies(String species) {
        System.out.println("Setting species from " + this.species.get() + "to " + species);
        this.species.set(species);
    }

    public String getSound() {
        return sound.get();
    }

    public StringProperty soundProperty() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound.set(sound);
    }

    public int getLegCount() {
        return legCount.get();
    }

    public IntegerProperty legCountProperty() {
        return legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount.set(legCount);
    }

    public Object getDate() {
        return date.get();
    }

    public ObjectProperty dateProperty() {
        return date;
    }

    public void setDate(Object date) {
        this.date.set(date);
    }

    public boolean isAlive() {
        return alive.get();
    }

    public BooleanProperty aliveProperty() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive.set(alive);
    }
}
