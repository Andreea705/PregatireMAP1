package org.example.model;

public class Fahrer {
    private int id;
    private String name;
    private String team;
    private FahrerStatus status;
    private int skillLevel;

    public Fahrer(int id, String name, String team, FahrerStatus status, int skillLevel) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.status = status;
        this.skillLevel = skillLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public FahrerStatus getStatus() {
        return status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        String statusStr = (status == FahrerStatus.ACTIV) ? "ACTIV" : "DNF";
        return "[#"+id +"]" + " " + name + " " + " ("+ team + ") " + "-" +statusStr + ", skill=" + skillLevel;
    }
}
