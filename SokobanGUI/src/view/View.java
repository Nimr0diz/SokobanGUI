package view;

import commons.CommonLevel;

public interface View {

	//void showSaveCompletedMessage(String filepath);
	//void showSaveFailedMessage(String message);
	void showSaveLevelMessage(boolean succeed,String params);
	//void showLoadCompletedMessge(String filepath);
	//void showLoadFailedMessage(String message);
	void showLoadLevelMessage(boolean succeed,String params);
	void positionHasChanged(boolean isMoved);
	void displayLevel(CommonLevel level);
	public void levelHasRestarted();
	void start();
	void stop();
	void levelHasFinished();

}
