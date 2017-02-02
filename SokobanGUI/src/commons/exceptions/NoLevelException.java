package commons.exceptions;

public class NoLevelException extends SokobanException {
	public NoLevelException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return "There is no loaded level.";
	}
	
	
}
