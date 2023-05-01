package com.gromit.calc.entity;

import com.gromit.calc.TickEnvironment;
import com.gromit.calc.util.Vec3d;

public class Tnt extends Entity {

    public int fuse;
    public boolean instantExplode;

    public Tnt(double x, double y, double z, double velocityX, double velocityY, double velocityZ, boolean track, boolean instantExplode) {
        this(new Vec3d(x, y, z), new Vec3d(velocityX, velocityY, velocityZ), track, instantExplode);
    }

    public Tnt(Vec3d position, Vec3d velocity, boolean track, boolean instantExplode) {
        super(position, velocity, track);
        fuse = 80;
        this.instantExplode = instantExplode;
    }

    @Override
    public void tick() {
        if (instantExplode) {
            alive = false;
            explode();
            return;
        }

        super.tick();

        if (fuse-- <= 0) {
            alive = false;
            explode();
        }
    }

    private void explode() {
        for (Entity entity : TickEnvironment.entities) {
            if (entity == this) continue;
            if (!entity.alive) continue;

            double deltaX = entity.position.x - position.x;
            double deltaY = entity.position.y - position.y;
            double deltaZ = entity.position.z - position.z;

            double distance = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
            if (distance >= 8 || distance == 0) continue;

            double effX = deltaX / distance;
            double effY = deltaY / distance;
            double effZ = deltaZ / distance;

            double exposure = 1 - distance / 8;

            entity.velocity.x += effX * exposure;
            entity.velocity.y += effY * exposure;
            entity.velocity.z += effZ * exposure;
        }
    }

    @Override
    public Entity duplicate() {
        return new Tnt(position.duplicate(), velocity.duplicate(), track, instantExplode);
    }
}
