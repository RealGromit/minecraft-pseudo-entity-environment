package com.gromit.calc;

import com.gromit.calc.entity.Entity;
import com.gromit.calc.entity.Sand;
import com.gromit.calc.entity.Tnt;

import java.util.ArrayList;
import java.util.List;

public class TickEnvironment {

    public static final List<Entity> entities = new ArrayList<>();
    private final Tnt tnt = new Tnt(0, 0, 0, 0, 0, 0, false, true);
    private final Sand sand = new Sand(0, 1, 1, 0, 0, 0, true);

    public TickEnvironment() {
        for (int i = 0; i < 100; i++) {
            entities.add(tnt.duplicate());
        }
        entities.add(sand);
        runEnvironment(80);
    }

    public void runEnvironment(int ticks) {
        for (int i = 0; i < ticks; i++)
            for (Entity entity : entities) {
                if (!entity.alive) continue;
                entity.tick();
            }

        sand.printLog();
    }
}
