package lesson2_1.online;


import java.util.Random;

public class Experience{


    public static void main(String[] args) {


        Heroes human = new Human("Человек Федор ", 0, 0);
        Heroes cat = new Cat("Кот Борис ", 0, 0);
        Heroes robot = new Robot("Робот Вася ", 0, 0);

        Heroes[] heroes = {human, cat, robot};
        System.out.println("******************************************************************************");
        for (int i=0; i < heroes.length; i++) {
            heroes[i].run();
            heroes[i].jump();
        }

        Obstacle treadmill = new Treadmill(0);
        Obstacle wall = new Wall(0);
        System.out.println("******************************************************************************");
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getRunMax() > treadmill.getDistance()){

                System.out.println(heroes[i].getName() + "успешно пробежал");
            }else {
                System.out.println(heroes[i].getName() + "не смог пробежать");
            }
            if (heroes[i].getJumpMax() > wall.getHeight()){
                System.out.println(heroes[i].getName() + "успешно перепрыгнул");
            }else {
                System.out.println(heroes[i].getName() + "не смог перепрыгнуть");
            }
        }

        Obstacle treadmill1 = new Treadmill(0);
        Obstacle treadmill2 = new Treadmill(0);
        Obstacle treadmill3 = new Treadmill(0);

        Obstacle wall1 = new Wall(0);
        System.out.println("******************************************************************************");
        Obstacle[] obstacle = {treadmill, wall, treadmill1, treadmill2, wall1, treadmill3};
        for (int i=0; i < heroes.length; i++){
            for (int j=0; j < obstacle.length; j++){
                if(obstacle[j].getDistance() != 0) {
                    if (obstacle[j].getDistance() < heroes[i].getRunMax()) {
                        System.out.println(heroes[i].getName() + "успешно пробежал,  ");
                    } else {
                        System.out.println(heroes[i].getName() + "не смог пробежать,  ");
                        break;
                    }
                }else {
                    if (obstacle[j].getHeight() < heroes[i].getJumpMax()) {
                        System.out.println(heroes[i].getName() + "успешно перепрыгнул,  ");
                    } else {
                        System.out.println(heroes[i].getName() + "не смог перепрыгнуть,  ");
                        break;
                    }
                }
            }
        }
    }
    static class Human implements Heroes {


        @Override
        public void run() {
            System.out.println("Человек побежал");
        }

        @Override
        public void jump() {
            System.out.println("Человек прыгнул");
        }

        protected String name;
        protected float runMax;
        protected float jumpMax;
        private final Random random = new Random();

        protected Human(String name, float runMax, float jumpMax) {
            this.name = name;
            this.runMax = runMax + random.nextFloat() * 500;
            this.jumpMax = jumpMax + random.nextFloat() * 2;


        }

        public float getRunMax() {
            return this.runMax;
        }
         public String getName() {
             return this.name;
         }

        @Override
        public float getJumpMax() {
            return this.jumpMax;
        }
    }

    static class Cat implements Heroes {
        @Override
        public void run() {
            System.out.println("Кот побежал");
        }

        @Override
        public void jump() {
            System.out.println("Кот прыгнул");
        }

        @Override
        public float getRunMax() {
            return this.runMax;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getJumpMax() {
            return this.jumpMax;
        }

        protected String name;
        protected float runMax;
        protected float jumpMax;
        private final Random random = new Random();

        protected Cat(String name, float runMax, float jumpMax) {
            this.name = name;
            this.runMax = runMax + random.nextFloat() * 300;
            this.jumpMax = jumpMax + random.nextFloat() * 3;


        }
    }

    static class Robot implements Heroes {

        @Override
        public void run() {
            System.out.println("Робот побежал");

        }

        @Override
        public void jump() {
            System.out.println("Робот порыгнул");
        }

        @Override
        public float getRunMax() {
            return this.runMax;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getJumpMax() {
            return this.jumpMax;
        }

        protected String name;
        protected float runMax;
        protected float jumpMax;
        private final Random random = new Random();

        protected Robot(String name, float runMax, float jumpMax) {
            this.name = name;
            this.runMax = runMax + random.nextFloat() * 1000;
            this.jumpMax = jumpMax + random.nextFloat() * 4;
        }
    }

    static class Treadmill implements Obstacle{
        protected float distance;

        private final Random random = new Random();

        protected Treadmill(float distance) {

            this.distance = distance + random.nextFloat() * 500;

        }
        @Override
        public float getDistance() {
            return this.distance;
        }

        @Override
        public float getHeight() {
            return 0;
        }
    }
    static class Wall implements Obstacle{

        protected float height;
        private final Random random = new Random();

        protected Wall(float height){

            this.height = height + random.nextFloat() * 0.5f;
        }
        @Override
        public float getDistance() {
            return 0;
        }
        @Override
        public float getHeight() {
            return this.height;
        }

    }
}
