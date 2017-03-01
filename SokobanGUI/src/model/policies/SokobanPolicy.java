package model.policies;



import commons.Direction2D;
import model.entities.SolidEntity;
import model.levels.Level;

public interface SokobanPolicy {
	public boolean move(Level level, SolidEntity se,Direction2D dir);
}
