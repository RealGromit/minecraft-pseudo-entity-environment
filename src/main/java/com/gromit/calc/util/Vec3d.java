package com.gromit.calc.util;

public class Vec3d {

    public double x;
    public double y;
    public double z;

    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3d add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vec3d add(double value) {
        x += value;
        y += value;
        z += value;
        return this;
    }

    public Vec3d add(Vec3d vector) {
        add(vector.x, vector.y, vector.z);
        return this;
    }

    public Vec3d subtract(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public Vec3d subtract(double value) {
        x -= value;
        y -= value;
        z -= value;
        return this;
    }

    public Vec3d subtract(Vec3d vector) {
        subtract(vector.x, vector.y, vector.z);
        return this;
    }

    public Vec3d multiply(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Vec3d multiply(double value) {
        x *= value;
        y *= value;
        z *= value;
        return this;
    }

    public Vec3d multiply(Vec3d vector) {
        multiply(vector.x, vector.y, vector.z);
        return this;
    }

    public Vec3d divide(double x, double y, double z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }

    public Vec3d divide(double value) {
        x /= value;
        y /= value;
        z /= value;
        return this;
    }

    public Vec3d divide(Vec3d vector) {
        divide(vector.x, vector.y, vector.z);
        return this;
    }

    public Vec3d duplicate() {
        return new Vec3d(x, y, z);
    }
}
