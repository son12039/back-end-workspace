package creature;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static final char ANSIORANGE = 0;

	public static void main(String[] args) {
    	World world = new World(20, 20);
        Creature initialCreature = new Creature(10, 10);
        world.addCreature(initialCreature);

        PredatorCreature predator = new PredatorCreature(5, 5); // 포식자 크리처 생성
        world.addPredator(predator); // 월드에 포식자 크리처 추가

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                world.spawnFood();
                world.update();
                displayWorld(world);
            }
        }, 0, 1000);
     }

    public static void displayWorld(World world) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_PURPLE = "\u001B[35m"; // ANSI 코드로 보라색 정의

        char[][] display = new char[20][20];

        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[i].length; j++) {
                display[i][j] = '.';
            }
        }

        for (Food food : world.getFoods()) {
            if (!food.isEaten()) {
                display[food.getX()][food.getY()] = 'F';
            }
        }

        for (Creature creature : world.getCreatures()) {
            display[creature.getX()][creature.getY()] = 'C';
        }

        for (PredatorCreature predator : world.getPredators()) {
            display[predator.getX()][predator.getY()] = 'P'; // 포식자 크리처를 P로 표시
        }

        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[i].length; j++) {
                if (display[i][j] == 'F') {
                    System.out.print(ANSI_GREEN + 'F' + ANSI_RESET);
                } else if (display[i][j] == 'C') {
                    System.out.print(ANSI_RESET + 'C' + ANSI_RESET);
                } else if (display[i][j] == 'P') {
                    System.out.print(ANSI_PURPLE + 'P' + ANSI_RESET);
                } else {
                    System.out.print(display[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
