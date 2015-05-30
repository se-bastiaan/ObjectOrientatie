package oo14;

import java.util.Random;

/**
 * OO1route66 initial class
 * @author Pieter Koopman
 *
 * The initial controller runs as a single thread
 */
public class Controller
{
    private int delay = 200;                // average sleep time
    private final Model model;              // the model
    private final Random random;            // a random generator
    public static boolean RUN = true;             // car can run in simulation

    /**
     * The constructor of the controller
     * @param model holds the cars
     */
    public Controller(Model model) {
        this.model  = model;
        random      = new Random();
    }

    /**
     * the run method from Thread
     * forever:
     *      move all cars
     *      sleep some time
     */
    public void run() {
        while (true) {

        }
    }

    /**
     * stop all cars by setting boolean run to false
     */
    public void stopCars() {
        RUN = false;
    }

    /**
     * start all cars by setting boolean run to true
     */
    public void resumeCars() {
        RUN = true;
    }
    
    public int getDelay() {
        return delay;
    }
    
    /**
     * set delay between maximum and minimum bounds
     * @param d 
     */
    public void setDelay(int d) {
        delay = Math.max(50, Math.min (2000, d));
    }
}
