package BRUN_MARTIN.Jeu_de_lettres;

import word;
public class dictionnaire_prof {

	private Cell origin = new Cell('0');
	
	public void addWord(Word w)
	{
		cell currentcell = origin;
		for(char currentLetter : w.toCharArray())
		{
			currentCell = currentCell.getOrCreate(currentLetter);
		}
		curre,tCell.getOcreate(cell.EOW);
				
	}
	
	public boolean isWordValid(String w){
		cell currentcell = origin;
		for(char currentLetter : w.toCharArray())
		{
			
			Optional<Cell>optional = currentCell.get(currentLetter);
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
		return currentCell.isEndOfWord();
		
	}
}
