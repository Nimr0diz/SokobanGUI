package commons;
//This enum represent the Two Dimensional Direction
public enum Direction2D{
	UP, RIGHT, DOWN, LEFT;
	
	   private Direction2D opposite;

	    static {
	        UP.opposite = DOWN;
	        RIGHT.opposite = LEFT;
	        DOWN.opposite = UP;
	        LEFT.opposite = RIGHT;
	    }

	    public Direction2D getOppositeDirection() {
	        return opposite;
	    }
}
