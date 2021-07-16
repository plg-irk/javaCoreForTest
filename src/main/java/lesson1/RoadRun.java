package lesson1;

public class RoadRun extends Course{
    public double lengthRoadRun;

    public RoadRun(double lengthRoadRun) {
        this.lengthRoadRun = lengthRoadRun;
    }

    public double getTimeToOvercomeRoadRun(CanRunning runner) {
        return runner.running(this);
    }

}
