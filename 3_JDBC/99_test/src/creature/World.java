package creature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class World {
    private int width;
    private int height;
    private List<Food> foods;
    private List<Creature> creatures;
    private List<PredatorCreature> predators;
    private Random random;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.foods = new ArrayList<>();
        this.creatures = new ArrayList<>();
        this.predators = new ArrayList<>();
        this.random = new Random();
    }

    public void spawnFood() {
        for (int i = 0; i < 3; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            foods.add(new Food(x, y));
        }
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void addPredator(PredatorCreature predator) {
        predators.add(predator);
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public List<PredatorCreature> getPredators() {
        return predators;
    }

    public void update() {
        List<Creature> newCreatures = new ArrayList<>();
        List<Creature> removedCreatures = new ArrayList<>();

        // Update creatures
        Iterator<Creature> creatureIterator = creatures.iterator();
        while (creatureIterator.hasNext()) {
            Creature creature = creatureIterator.next();
            creature.move(width, height);
            creature.eat(foods);
            creature.shrink();

            if (creature.shouldDivide()) {
                newCreatures.add(creature.divide());
            }

            if (creature.shouldRemove()) {
                removedCreatures.add(creature);
                creatureIterator.remove(); // Iterator를 사용한 안전한 삭제
            }
        }

        creatures.addAll(newCreatures);
        creatures.removeAll(removedCreatures);

        foods.removeIf(Food::isEaten);

        // Update predators
        Iterator<PredatorCreature> predatorIterator = predators.iterator();
        while (predatorIterator.hasNext()) {
            PredatorCreature predator = predatorIterator.next();
            predator.move(width, height);
            predator.eat(creatures);
            predator.shrink();

            if (predator.shouldRemove()) {
                predatorIterator.remove(); // Iterator를 사용한 안전한 삭제
            }
        }
    }

}



