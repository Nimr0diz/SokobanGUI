package model.levels.loaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.Position2D;
import model.entities.SolidEntity;
import model.entities.UnsolidEntity;
import model.entities.creators.CharToEntity;
import model.entities.creators.SolidCreator;
import model.entities.creators.UnsolidCreator;
import model.levels.Level;

public class MyTextLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((in)));
		Level level = new Level();
		int i=0;
		String line;
			
			//This loop runs on every line in the stream and tries to add it into the Level
			while((line=br.readLine())!=null)
			{
				for(int j=0;j<line.length();j++)
				{
					//Create the specific creator for the entity that the char represent it.
					SolidCreator sc = new CharToEntity().getSolidCreator(line.charAt(j));
					if(sc!=null)//progress if there is concurrent creator for this char
					{
						SolidEntity se = sc.create();
						if(se!=null)
						{
							se.setPosition(new Position2D(j,i));
							level.addEntity(se);
						}
					}
					//Create the specific creator for the entity that the char represent it.
					UnsolidCreator usc = new CharToEntity().getUnsolidCreator(line.charAt(j));
					if(usc!=null)//progress if there is concurrent creator for this char
					{
						UnsolidEntity use = usc.create();
						if(use!=null)
						{
							use.setPosition(new Position2D(j,i));
							level.addEntity(use);
						}
					}
				}
				i++;
			}
			
			br.close();
		return level;
	}

}
