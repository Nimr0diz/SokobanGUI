package commons;

public class CommonEntity {
	String type;
	CommonPosition position;
	
	public CommonEntity()
	{
		this.type = "";
		this.position = new CommonPosition();
	}
	
	public CommonEntity(String type,CommonPosition position)
	{
		this.type = type;
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CommonPosition getPosition() {
		return position;
	}

	public void setPosition(CommonPosition position) {
		this.position = position;
	}
	
}
