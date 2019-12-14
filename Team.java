package Lesson_1.Marathon.Competitor;

public class Team {
    private String name;
    private Competitor[] members;

    public Competitor[] getMembers() {
        return members;
    }

    public Team(String name, Competitor...members) {
        this.name = name;
        this.members = members;
    }

    public void showResults() {
        for (Competitor m: members) {
             if(m.isOnDistance()) {
                 m.info();
             }
        }
    }
}