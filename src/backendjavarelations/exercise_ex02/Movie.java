package backendjavarelations.exercise_ex02;

public class Movie {
    
    private String title;
    private int duration;
    private int minAge;
    private String director;

    public Movie(String title, int duration, int minAge, String director) {
        this.title = title;
        this.duration = duration;
        this.minAge = minAge;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    @Override
    public String toString() {
        return title + ". " + director + ". " 
                + duration + " mins. " + minAge + " años.";
    }
}
