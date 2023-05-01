package com.gromit.calc.entity;

import com.gromit.calc.interfaces.Tickable;
import com.gromit.calc.interfaces.Trackable;
import com.gromit.calc.util.Vec3d;

import java.util.ArrayList;
import java.util.List;

public class Entity implements Tickable, Trackable {

    protected final Vec3d position;
    protected final Vec3d velocity;
    protected final List<Vec3d> positions;
    protected final List<Vec3d> velocities;
    public boolean alive;
    public boolean track;

    public Entity(double x, double y, double z, double velocityX, double velocityY, double velocityZ, boolean track) {
        this(new Vec3d(x, y, z), new Vec3d(velocityX, velocityY, velocityZ), track);
    }

    public Entity(Vec3d position, Vec3d velocity, boolean track) {
        this.position = position;
        this.velocity = velocity;
        positions = new ArrayList<>();
        velocities = new ArrayList<>();
        alive = true;
        this.track = track;
    }

    @Override
    public void tick() {
        if (!alive) return;

        velocity.y -= 0.03999999910593033;
        move();
        velocity.multiply(0.9800000190734863);
        track();
    }

    private void move() {
        position.add(velocity);
    }

    @Override
    public void track() {
        if (!track) return;

        positions.add(position.duplicate());
        velocities.add(velocity.duplicate());
    }

    public void printLog() {
        if (!track) return;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < positions.size(); i++) {
            Vec3d position = positions.get(i);
            builder.append(String.format("Position tick: %d\t | x: %f\t y: %f\t z: %f%n", i + 1, position.x, position.y, position.z));
        }
        builder.append("\n");

        for (int i = 0; i < velocities.size(); i++) {
            Vec3d velocity = velocities.get(i);
            builder.append(String.format("Velocity tick: %d\t | x: %f\t y: %f\t z: %f%n", i + 1, velocity.x, velocity.y, velocity.z));
        }
        System.out.println(builder);
    }

    public Entity duplicate() {
        return new Entity(position, velocity, track);
    }
}
