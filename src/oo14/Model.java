package oo14;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JFrame;

/**
 * OO1route66 initial class
 * @author Pieter Koopman
 *
 * The class model holds all cars in the simulation
 */
public class Model extends Observable
{
	private final Car [] cars;
    private final Driver [] drivers;
	public static final int
//       DIRECTIONS = 4,                  // for a crossing
       DIRECTIONS = 4,                  // for a single road
       NUMBEROFCARS = 5 * DIRECTIONS;   // total number of cars in system
        
        private final ArrayList<JFrame> views;


    /**
     * Constructor: create all cars
     */
    public Model() {
        views = new ArrayList<JFrame>();
        cars = new Car [NUMBEROFCARS];
        drivers = new Driver [NUMBEROFCARS];

        for (int c = 0; c < NUMBEROFCARS; c += 1) {
            cars[c] = new Car(c);
        }

        for (int c = 0; c < NUMBEROFCARS; c += 1) {
            Driver driver = Driver.init(c, cars, this);
            drivers[c] = driver;
        }
    }
    
    /**
     * add the view to this model. It will be repainted upon an update
     * @param view 
     */
    public void addView(JFrame view) {
        views.add(view);
    }

    /**
     * get a car from the model
     * @param i numbers of required car
     * @return the car itself (not a copy)
     */
    public Car getCar(int i) {
        return cars[i];
    }
    
    /**
     * repaint all views
     */
    public void update() {
        for (JFrame view: views) {
            view.repaint();
        }
    }
}
