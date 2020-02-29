package gigaclub.farmworldreset.server;

abstract public class Farmworld {

    protected int resettimer;
    protected int spawn_x;
    protected int spawn_y;
    protected int spawn_z;
    protected int slots;

    public Farmworld(int resettimer, int spawn_x, int spawn_y, int spawn_z, int slots) {
        this.resettimer = resettimer;
        this.spawn_x = spawn_x;
        this.spawn_y = spawn_y;
        this.spawn_z = spawn_z;
        this.slots = slots;
    }
}
