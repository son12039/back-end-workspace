package creature;

import java.util.List;
import java.util.Random;

public class Creature {
    private int x;
    private int y;
    private double biomass;
    private boolean ateFood = false;
    private static final double MOVE_ENERGY_COST = 0.03;
    private static final double SHRINK_RATE = 0.01;
    private static final double GROWTH_RATE = 1.0;
    private static final double DIVIDE_BIOMASS = 10.0;
    private static final double MIN_BIOMASS = 0.3;

    private Random random;

    public Creature(int x, int y) {
        this.x = x;
        this.y = y;
        this.biomass = 1.0;
        this.random = new Random();
    }

    public void move(int width, int height) {
        if (!ateFood) {
            int moveX = random.nextInt(3) - 1;
            int moveY = random.nextInt(3) - 1;

            for (int i = 0; i < 3; i++) { // 최대 3칸까지 이동
                x = (x + moveX + width) % width;
                y = (y + moveY + height) % height;
                biomass -= MOVE_ENERGY_COST;

                if (x < 0) x = width - 1;
                if (y < 0) y = height - 1;

                if (ateFood) break; // 먹이를 먹으면 이동을 멈춤
            }
        }
        ateFood = false; // 다음 이동을 위해 초기화
    }

    public void eat(List<Food> foods) {
        for (Food food : foods) {
            if (!food.isEaten() && food.getX() == x && food.getY() == y) {
                food.eat();
                biomass += GROWTH_RATE;
                ateFood = true;
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

    public boolean shouldDivide() {
        return biomass >= DIVIDE_BIOMASS;
    }

    public Creature divide() {
        biomass /= 2;
        return new Creature(x, y);
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
