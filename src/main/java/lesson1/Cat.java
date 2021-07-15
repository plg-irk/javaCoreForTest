package lesson1;

public class Cat implements CanRunning {
    final String name;
    private int speedHeight;
    private int speedLength;
    private int maxHeight;
    private int maxLength;
    private boolean statusCompetitor;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", speedHeight=" + speedHeight +
                ", speedLength=" + speedLength +
                ", maxHeight=" + maxHeight +
                ", maxLength=" + maxLength +
                ", status=" + statusCompetitor +
                '}';
    }

    public Cat(String name,
               int speedHeight, int speedLength,
               int maxHeight, int maxLength,
               boolean status) {

        this.name = name;
        this.statusCompetitor = status;

        if (speedHeight < 0 || speedLength < 0 || maxHeight < 0 || maxLength < 0) {
            System.out.println("Вы задали некорректные параметры");
        } else {
            this.speedHeight = speedHeight;
            this.speedLength = speedLength;
            this.maxHeight = maxHeight;
            this.maxLength = maxLength;
        }
    }

    public double running(RoadRun roadRun) {
        double timeToOvercome = 0;
        if (statusCompetitor) {
            if (roadRun.lengthRoadRun < maxLength) {
                timeToOvercome = roadRun.lengthRoadRun / speedLength;
                System.out.println("Я кот, пробежал " + roadRun.lengthRoadRun + " за "
                        + timeToOvercome);
            } else {
                statusCompetitor = false;
                System.out.println("Я кот, я не могу пробежать " + roadRun.lengthRoadRun);
            }
        } else System.out.println("Кот не учавствует в преодалении предпятствий.");
        return timeToOvercome;
    }
}
