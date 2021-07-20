package lesson1;

public class Human extends Team implements CanRunning, CanJumping {
    final String name;
    private int speedLength;
    private int maxHeight;
    private int maxLength;
    private boolean statusCompetitor;

    @Override
    public String toString() {
        return "Human {" +
                "name='" + name + '\'' +
                ", speedLength=" + speedLength +
                ", maxHeight=" + maxHeight +
                ", maxLength=" + maxLength +
                ", status=" + statusCompetitor +
                '}';
    }

    public Human(String name,
                 int speedLength,
                 int maxHeight, int maxLength,
                 boolean status) {

        this.name = name;
        this.statusCompetitor = status;

        if (speedLength < 0 || maxHeight < 0 || maxLength < 0) {
            System.out.println("Вы задали некорректные параметры");
        } else {
            this.speedLength = speedLength;
            this.maxHeight = maxHeight;
            this.maxLength = maxLength;
        }
    }

    public double running(RoadRun roadRun) {
        double timeToOvercome = 0;
        if (statusCompetitor) {
            if (roadRun.lengthRoadRun <= maxLength) {
                timeToOvercome = roadRun.lengthRoadRun / speedLength;
                System.out.println("Я - человек, пробежал " + roadRun.lengthRoadRun + " за "
                        + timeToOvercome);
            } else {
                statusCompetitor = false;
                System.out.println(" Я - человек, я не могу пробежать " + roadRun.lengthRoadRun);
            }
        } else System.out.println("  Человек не учавствует в преодалении препятствий.");
        return timeToOvercome;
    }

    public double jumping(WallForJump wallForJump) {
        if (statusCompetitor) {
            if (wallForJump.heightWall <= maxHeight) {
                System.out.println("Я - человек, я перепрыгнул " + wallForJump.heightWall);
            } else {
                statusCompetitor = false;
                System.out.println(" Я - человек, я не могу перепрыгнуть " + wallForJump.heightWall);
            }
        } else System.out.println("  Человек не учавствует в преодалении препятствий.");
        return 0;
    }
}
