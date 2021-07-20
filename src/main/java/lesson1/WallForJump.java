package lesson1;

public class WallForJump extends Course {
    public double heightWall;

    public WallForJump(double heightWall) {
        this.heightWall = heightWall;
    }

    public double getTimeToOvercomeWall(CanJumping jumper) {
        return jumper.jumping(this);
    }

}
