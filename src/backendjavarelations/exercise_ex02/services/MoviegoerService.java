package backendjavarelations.exercise_ex02.services;

import backendjavarelations.exercise_ex02.Moviegoer;
import java.util.ArrayDeque;
import java.util.Queue;

public class MoviegoerService {
    
    private final Queue<Moviegoer> queue;

    public MoviegoerService() {
        queue = new ArrayDeque<>();
    }
    
    public void generateMoviegoers() {
        int quantity = (int) (Math.random() * 50);
        
        for (int i = 0; i < quantity; i++) {
            queue.add(new Moviegoer("Person " + i+1, 
                    (int) (Math.random()*50 + 7),
                    (int) (Math.random()*20)));
        }
    }
    
    public Queue<Moviegoer> getQueue() {
        return queue;
    }
    
}
