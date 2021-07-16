package lesson1;

public class Main {
    public static void main(String[] args) {

        Course[] courses = new Course[5];

        Cat cat = new Cat("Barsic",
                10, 100,
                5, 500, true);

        double dict1 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        courses[0] = new RoadRun(dict1);
        int dict2 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        courses[1] = new RoadRun(dict2);
        int dict3 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        courses[2] = new RoadRun(dict3);

        for (int i = 0; i < 3; i++) {
            courses[i] = (RoadRun) courses[i];
            ((RoadRun) courses[i]).getTimeToOvercomeRoadRun(cat);
        }



    }
}
