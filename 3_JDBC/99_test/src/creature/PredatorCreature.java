package creature;

import java.util.List;
import java.util.Random;

public class PredatorCreature {
    private int x;
    private int y;
    private double biomass;
    private boolean ateCreature = false;
    private static final double MOVE_ENERGY_COST = 0.03;
    private static final double SHRINK_RATE = 0.01;
    private static final double MIN_BIOMASS = 0.3;

    private Random random;

    public PredatorCreature(int x, int y) {
        this.x = x;
        this.y = y;
        this.biomass = 1.0;
        this.random = new Random();
    }

    public void move(int width, int height) {
        if (!ateCreature) {
            int moveX = random.nextInt(3) - 1;
            int moveY = random.nextInt(3) - 1;

            for (int i = 0; i < 3; i++) { // 최대 3칸까지 이동
                x = (x + moveX + width) % width;
                y = (y + moveY + height) % height;
                biomass -= MOVE_ENERGY_COST;

                if (x < 0) x = width - 1;
                if (y < 0) y = height - 1;

                if (ateCreature) break; // 크리처를 잡아먹으면 이동을 멈춤
            }
        }
        ateCreature = false; // 다음 이동을 위해 초기화
    }

    public void eat(List<Creature> creatures) {
        for (Creature creature : creatures) {
            if (creature.getX() == x && creature.getY() == y) {
                creatures.remove(creature);
                biomass += creature.getBiomass();
                ateCreature = true;
                break;
            }
        }
    }

    public void shrink() {
        biomass -= SHRINK_RATE;
        if (biomass < MIN_BIOMASS) {
            biomass = MIN_BIOMASS;
        }
    }

    public boolean shouldRemove() {
        return biomass <= MIN_BIOMASS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getBiomass() {
        return biomass;
    }
}

