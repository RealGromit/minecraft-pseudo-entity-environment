package com.gromit.calc.entity;

import com.gromit.calc.util.Vec3d;

public class Sand extends Entity {

    public Sand(double x, double y, double z, double velocityX, double velocityY, double velocityZ, boolean track) {
        this(new Vec3d(x, y, z), new Vec3d(velocityX, velocityY, velocityZ), track);
    }

    public Sand(Vec3d position, Vec3d velocity, boolean track) {
        super(position, velocity, track);
    }
}
