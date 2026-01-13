package org.example.model;

public class RennenErignis {

    private int id;
    private int fahrerId;
    private EreignisTyp typ;
    private int basePoints;
    private int lap;

    public RennenErignis(int id, int fahrerId, EreignisTyp typ, int basePoints, int lap) {
        this.id = id;
        this.fahrerId = fahrerId;
        this.typ = typ;
        this.basePoints = basePoints;
        this.lap = lap;
    }

    public int getId() {
        return id;
    }

    public int getFahrerId() {
        return fahrerId;
    }

    public EreignisTyp getTyp() {
        return typ;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public int getLap() {
        return lap;
    }
}
