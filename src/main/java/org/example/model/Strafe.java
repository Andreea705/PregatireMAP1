package org.example.model;

public class Strafe {
    private int id;
    private int fahereId;
    private StrafeGrund grund;
    private int seconds;
    private int lap;

    public Strafe(int id, int fahereId, StrafeGrund grund, int seconds, int lap) {
        this.id = id;
        this.fahereId = fahereId;
        this.grund = grund;
        this.seconds = seconds;
        this.lap = lap;
    }

    public int getId() {
        return id;
    }

    public int getFahereId() {
        return fahereId;
    }

    public StrafeGrund getGrund() {
        return grund;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getLap() {
        return lap;
    }
}
