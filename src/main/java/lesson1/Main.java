package lesson1;

public class Main {
    public static void main(String[] args) {

        Course[] courses = new Course[5];
        Team[] teams = new Team[3];

        teams[0] = new Cat("Barsic",
                100,
                5, 500, true);
        teams[1] = new Human("Max",
                25,
                2, 1000, true);
        teams[2] = new Robot("Robocop",
                150,
                1, 1000, true);

        int dict1 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        courses[0] = new RoadRun(dict1);
        int dict2 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        courses[2] = new RoadRun(dict2);
        int dict3 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        courses[4] = new RoadRun(dict3);
        int height1 = (int) (Math.random() * (4 - 1) + 1);
        courses[1] = new WallForJump(height1);
        int height2 = (int) (Math.random() * (4 - 1) + 1);
        courses[3] = new WallForJump(height2);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (courses[i] instanceof RoadRun)
                    ((RoadRun) courses[i]).getTimeToOvercomeRoadRun((CanRunning) teams[j]);
                else ((WallForJump) courses[i]).getTimeToOvercomeWall((CanJumping) teams[j]);
            }
        }
    }
}
