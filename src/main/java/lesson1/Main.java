package lesson1;

public class Main {
    public static void main(String[] args) {

        RoadRun[] roadRuns = new RoadRun[3];

        Cat cat = new Cat("Barsic",
                10, 100,
                5, 500, true);

        int dict1 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        roadRuns[0] = new RoadRun(dict1);
        int dict2 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        roadRuns[1] = new RoadRun(dict2);
        int dict3 = ((int) (Math.random() * (10 - 1) + 1)) * 100;
        roadRuns[2] = new RoadRun(dict3);


        for (RoadRun roadRun: roadRuns) {
            roadRun.getTimeToOvercomeRoadRun(cat);
        }


    }
}
