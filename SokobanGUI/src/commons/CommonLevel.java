package commons;

public class CommonLevel {
	String[][] field;
	CommonEntity[] entities;
	
	public CommonLevel() {
		this.field = null;
		this.entities = null;
	}
	
	public CommonLevel(String[][] field, CommonEntity[] entities)
	{
		this.field = field;
		this.entities = entities;
	}

	public String[][] getField() {
		return field;
	}

	public void setField(String[][] field) {
		this.field = field;
	}

	public CommonEntity[] getEntities() {
		return entities;
	}

	public void setEntities(CommonEntity[] entities) {
		this.entities = entities;
	}
	
	
}
