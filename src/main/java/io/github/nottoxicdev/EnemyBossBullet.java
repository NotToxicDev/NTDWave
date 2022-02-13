package io.github.nottoxicdev;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
    private Handler handler;
    Random r = new Random();

    public EnemyBossBullet(Float x, Float y, ID id, GroupID gid, Handler handler) {
        super(x, y, id, gid);

        this.handler = handler;

        velX = (r.nextInt(5 - -5) + -5);
        velY = 10;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 59) {
            handler.remObject(this);
        }
        if (x <= 0 || x >= Game.WIDTH - 40) {
            handler.remObject(this);

        }

        handler.addObject(new Trail(x, y, ID.Trail, GroupID.Effect, Color.RED, 24, 24, 0.1f, handler));
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (Game.showCollisionBoxes) {
            g.setColor(Color.MAGENTA);
            g2d.draw(getBounds());
        }
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 24, 24);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 24, 24);
    }

}
