#Bataille

---
_Reproduction du jeu de bataille en Java._

##Lancement du programme

---
Lancer à l'aide d'un IDE : `src/Bataille.java`.


Ou avec la commande suivante en étant dans le dossier `out/production/Bataille`:
```bash
  java Bataille
```
##Déroulement

---
###Initialisation

Au lancement de la partie, l'ensemble du jeu de carte est créé, mélangé puis distribué aux deux joueurs.

###Règles

La partie est effectuée avec un paquet de 52 cartes mélangé aléatoirement. Chaque joueur dispose donc de 26 cartes au lancement de la partie.
Le jeu se déroule par défaut en 20 manches gagnantes mais peut être modifié en changeant la valeur de la variable `maxPoint` dans le fichier `Bataille.java`.

####Manche

À chaque manche, les deux joueurs piochent une carte de leur paquet et la joue.
Le gagnant est celui qui à la carte la plus forte.
En cas d'égalité des cartes, il y a bataille.

####Bataille

Chaque joueur pioche une nouvelle carte et la joue jusqu'à qu'il y est un gagnant.
Ce dernier récupèrera l'ensemble des cartes misent en jeu.


##Détail

Le fichier `umlBataille.uxf` peut être ouvert avec un logiciel tel que [UMLet](https://www.umlet.com/) ou utiliser `uml.png`.