package backendjavarelations.exercise_ex02.services;

import backendjavarelations.exercise_ex02.Moviegoer;
import java.util.ArrayDeque;
import java.util.Queue;

public class MoviegoerService {
    
    private static final int MIN_PERSONS = 30;
    private static final int MAX_PERSONS = 60;
    private static final int MAX_AGE_BASE = 50;
    private static final int MIN_AGE = 7;
    private static final int MAX_MONEY = 30;
    
    private final Queue<Moviegoer> queue;

    public MoviegoerService() {
        queue = new ArrayDeque<>();
    }
    
    public void generateMoviegoers() {
        int quantity = (int) (Math.random() * (MAX_PERSONS - MIN_PERSONS) + MIN_PERSONS);
        queue.clear();
        
        for (int i = 0; i < quantity; i++) {
            queue.add(new Moviegoer("Person " + (i+1), 
                    (int) (Math.random() * MAX_AGE_BASE + MIN_AGE),
                    (int) (Math.random() * MAX_MONEY)));
        }
    }
    
    public Queue<Moviegoer> getQueue() {
        return queue;
    }
    
    public Moviegoer giveNextMoviegoer() {
        return queue.poll();
    }
    
    public boolean isPeopleInQueue() {
        return !queue.isEmpty();
    }
    
}
