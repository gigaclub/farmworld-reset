package gigaclub.farmworldreset.server;

abstract public class Farmworld {

    protected String name;
    protected int resettimer;
    protected double spawn_x;
    protected double spawn_y;
    protected double spawn_z;
    protected int slots;

    public Farmworld(String name, int resettimer, double spawn_x, double spawn_y, double spawn_z, int slots) {
        this.name = name;
        this.resettimer = resettimer;
        this.spawn_x = spawn_x;
        this.spawn_y = spawn_y;
        this.spawn_z = spawn_z;
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public int getResettimer() {
        return resettimer;
    }

    public double getSpawn_x() {
        return spawn_x;
    }

    public double getSpawn_y() {
        return spawn_y;
    }

    public double getSpawn_z() {
        return spawn_z;
    }

    public int getSlots() {
        return slots;
    }
}
