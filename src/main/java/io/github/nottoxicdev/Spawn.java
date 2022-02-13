package io.github.nottoxicdev;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;
    int i = 0;

    public static int scoreSpeed = 2;
    public static float fixedWidth = Game.WIDTH - 64;
    public static float fixedHeight = Game.HEIGHT - 64;

    boolean start = true;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        i++;
        if (i > scoreSpeed) {
            scoreKeep++;
            i = 0;
        }

        if (start) {
            handler.addObject(
                    new BasicEnemy(r.nextFloat(fixedWidth), r.nextFloat(fixedHeight), ID.BasicEnemy, GroupID.Enemy,
                            handler));
            start = false;
        }

        if (scoreKeep >= 100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() == 2) {
                handler.addObject(
                        new BasicEnemy(r.nextFloat(fixedWidth), r.nextFloat(fixedHeight), ID.BasicEnemy, GroupID.Enemy,
                                handler));
            } else if (hud.getLevel() == 3) {
                handler.addObject(
                        new VerticalEnemy(r.nextFloat(fixedWidth), 0f, ID.VerticalEnemy, GroupID.Enemy,
                                handler));
            } else if (hud.getLevel() == 4) {
                handler.addObject(
                        new SmartEnemy(r.nextFloat(fixedWidth), 0f, ID.SmartEnemy, GroupID.Enemy,
                                handler));
            }
        }

    }
}
