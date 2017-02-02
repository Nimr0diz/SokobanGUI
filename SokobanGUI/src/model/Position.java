package model;

import java.io.Serializable;
//This interface represent abstract Position and each specific Position implements it.
public interface Position<D> extends Serializable{
	//This method change the coordinates according to the Direction by a known offset.
	public void move(D dir ,int offset);
}
