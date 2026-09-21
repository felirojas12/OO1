package ar.edu.unlp.info.oo1;

import java.util.List;
import java.util.ArrayList;

public class Farola {
    private boolean state;
    private List<Farola> neighbors;

    public Farola() {
        state = false;
        neighbors = new ArrayList<>();
    }

    public void pairWithNeighbor(Farola farola) {
        if (!neighbors.contains(farola)) {
            neighbors.add(farola);
            farola.pairWithNeighbor(this);
        }
    }

    public List<Farola> getNeighbors() {
        return neighbors;
    }

    public void turnOn() {
        if (this.isOff()) { state = true;
        for (Farola neighbor: neighbors)
            neighbor.turnOn();
        }
    }

    public void turnOff() {
        if (this.isOn()) {
            state = false;
            for (Farola neighbor: neighbors) {
                neighbor.turnOff();
            }
        }
    }

    public boolean isOn() {
        return state;
    }

    public boolean isOff() {
        return !state;
    }
}
