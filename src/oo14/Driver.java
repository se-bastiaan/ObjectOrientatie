package oo14;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sébastiaan Versteeg s4459636
 */
public class Driver implements Runnable {

    private int delay = 200;
    private final Random random;

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private Car car, otherCar;
    private Model model;

    /**
     * Init new car
     * @param c current number
     * @param cars number of car in front
     * @return driver
     */
    public static Driver init(int c, Car[] cars, Model model) {
        int prevC = 0;
        if(Model.DIRECTIONS == 2) {
            prevC = c - 2;
            if (prevC <= 0) {
                if (Direction.intToDirection(c).equals(Direction.East)) {
                    prevC = Model.NUMBEROFCARS - 2;
                } else {
                    prevC = Model.NUMBEROFCARS - 1;
                }
            }
        } else {
            prevC = c - 4;
            if (prevC <= 0) {
                if (Direction.intToDirection(c).equals(Direction.East)) {
                    prevC = Model.NUMBEROFCARS - 2;
                } else {
                    prevC = Model.NUMBEROFCARS - 1;
                }
            }
        }

        Driver driver = new Driver(cars[c], cars[prevC], model);
        executorService.submit(driver);
        return driver;
    }

    /**
     * Create driver
     * @param c Car
     * @param prevC Car
     * @param model Model
     */
    private Driver(Car c, Car prevC, Model model) {
        car = c;
        otherCar = prevC;
        this.model = model;
        random = new Random();
    }

    /**
     * Runnable run
     */
    @Override
    public void run() {
        while(true) {
            while(Controller.RUN) {
                if (!car.collides(otherCar)) {
                    car.step();
                    model.update();

                    try { // sleep can throw an exception
                        Thread.sleep(delay / 2 + random.nextInt(delay));
                    } catch (InterruptedException e) { // catch the exception thrown by sleep
                        System.out.println("An exception in Controller: " + e);
                    }
                } else {
                    try { // sleep can throw an exception
                        Thread.sleep(delay * 3 / 2 + random.nextInt(delay));
                    } catch (InterruptedException e) { // catch the exception thrown by sleep
                        System.out.println("An exception in Controller: " + e);
                    }
                }
            }
        }
    }

}
