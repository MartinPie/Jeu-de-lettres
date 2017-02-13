package BRUN_MARTIN.Jeu_de_lettres;

import BRUN_MARTIN.Jeu_de_lettres.Word;

import java.util.Optional;

import BRUN_MARTIN.Jeu_de_lettres.Cell;

public class Dictionnaire {

	private Cell origin = new Cell('0');
	
	public void addWord(String w)
	{
		Cell currentcell = origin;
		for(char currentLetter : w.toCharArray())
		{
			currentcell = currentcell.getOrCreate(currentLetter);
		}
		currentcell.getOrCreate(Cell.EOW);
				
	}
	
	public boolean isWordValid(String w){
		Cell currentcell = origin;
		for(char currentLetter : w.toCharArray())
		{
			
			Optional<Cell>optional = currentcell.get(currentLetter);
			if(optional.isPresent())
			{
				return false;
			}
			//currentCell = currentCell.get(currentLetter);
		
			/*if(currentCell == null)
		{
				return false;
			}*/
		}
		return currentcell.isEndOfWord();
		
	}
}
