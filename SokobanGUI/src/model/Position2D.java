package model;

import java.io.Serializable;

import commons.CommonPosition;
import commons.Direction2D;
//This is Two Dimensional Position. 
public class Position2D implements Position<Direction2D>{
	int x;
	int y;

	public Position2D() {
		this.x=0;
		this.y=0;
	}
	
	public Position2D(int x,int y) {
		setX(x);
		setY(y);
	}
	
	//This is the copy constructor
	public Position2D(Position2D pos){
		setX(pos.x);
		setY(pos.y);
	}
	
	public Position2D(CommonPosition cp){
		setX(cp.getX());
		setY(cp.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
			this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
			this.y = y;
	}
	
	
	public void move(Direction2D dir ,int offset)
	{
		switch(dir)
		{
		case UP:
			this.y-=offset;
			break;
		case RIGHT:
			this.x+=offset;
			break;
		case DOWN:
			this.y+=offset;
			break;
		case LEFT:
			this.x-=offset;
			break;
		}
	}
	
	@Override
	public int hashCode(){
		String hc = x+","+y;
		return hc.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Position2D pos = (Position2D)obj;
		if(pos.x == this.x && pos.y == this.y)
			return true;
		return false;
	}
	
	public CommonPosition getCommon()
	{
		return new CommonPosition(x,y);
	}
}
