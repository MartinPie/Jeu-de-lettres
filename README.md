#TP Architecture Logicielle / Inf4043 - 2017 - Jeux de lettres
**Par:**  
- Jean-Baptiste BRUN  
- Pierre MARTIN  
  
  
### - Description de l'architecture  
Nous avons 3 packages :  
- un pour les test, 
- un pour les ressources (fichiers txt)
- un pour la mécanique du jeu
  
  

###Principes SOLID et Design Pattern
####1. Design Pattern : Le Singleton
Dans notre projet, nous avons 2 classes qui sont des singletons : la classe Jar (le pot commun), et la classe Dictionnary. En effet, il est nécessaire dans notre projet de n'avoir qu'une seule et même instance de ces deux classes. 

  
####2. Principe SOLID : Responsabilité unique
Dans notre projet, chaque classe et chaque fonction ont une et une seule responabilité.
En effet, la classe "Jar" gère le pot commun, la classe "Parser" transforme le fichier de dictionnaire en liste de mots, la classe "Printer" écrit les messages(pour plus de lisibilité dans le code), ...
  
  
####3. Principe SOLID : 
