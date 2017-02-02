package model.levels.savers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import model.Position2D;
import model.entities.SolidEntity;
import model.entities.UnsolidEntity;
import model.entities.creators.EntityToChar;
import model.levels.Level;


public class MyTextLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(Level level, OutputStream os) throws IOException {
		SolidEntity[] solidArray = level.getSolidArray();
		UnsolidEntity[] unsolidArray = level.getUnsolidArray();
		
		int width = 0;
		int height = 0;
		
		//This loop run over all the solid entities and set width and height of the level
		for(int i=0;i<solidArray.length;i++)
		{
			Position2D temp = solidArray[i].getPosition(); 
			if(temp.getX()>width)
				width = temp.getX();
			if(temp.getY()>height)
				height = temp.getY();
		}
		width++;
		height++;
		char[][] field = new char[height][width];
		//This loop set all the places in the matrix to Empty Space (by default).
		for(int i=0;i<height;i++)
			for(int j=0;j<width;j++)
				field[i][j] = ' ';
		EntityToChar etc = new EntityToChar();
		
		//This loop take every UnsolidEntity and place it in the matrix in the current position
		for(UnsolidEntity use:unsolidArray)
		{
			char decodeChar = etc.getChar(use);
				field[use.getPosition().getY()][use.getPosition().getX()] = decodeChar;
		}
		
		//This loop take every UnsolidEntity and place it in the matrix in the current position
		for(SolidEntity se:solidArray)
		{
			char decodeChar = etc.getChar(se);
				field[se.getPosition().getY()][se.getPosition().getX()] = decodeChar;
		}
		
		BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(os));
		//This loop take each matrix cell print to the OutputStream.
		for(int i=0;i<height;i++)
		{
			String line = "";
			for(int j=0;j<width;j++)
				line+=field[i][j];
			bos.write(line);
			bos.newLine();
		}

			bos.flush();
			if(!os.equals(System.out))
				bos.close();
		

	}

}
