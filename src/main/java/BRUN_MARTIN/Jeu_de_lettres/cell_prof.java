package BRUN_MARTIN.Jeu_de_lettres;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* ne pas mettre public*/
class cell_prof {
	
	private char c;
	public static final char EOW = '\0'; 
	Map<Character.cell_prof> cells = new HashMap<>();
	
	public Cell_prof(char c)
	{
		this.c=c;
	}

	public void getOrCreate(char firstletter)
	{
		return cells.computeIfAbsent(firstletter, l ->  new Cell(l));
		
		/*cell_prof result = cells.get(firstletter);
		if(cells.containsKey(firstLetter))
		{
			new cell_prof(firstletter);
			cells.push(firstletter, new cell_prof(firstletter));
		
		}
		return cells.get(firstletter);*/
		
	}
	
	public void isEndOfWord()
	{
		return children.get(EOW)!= null;
	}
	
	public Optional<Cell> get(char currentLetter)
	{
		/* todo renomme cells en children*/
		return Optional.ofNullable(cells.get(currentLetter));
	}
}


