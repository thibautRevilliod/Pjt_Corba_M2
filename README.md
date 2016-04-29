# Pjt_Corba_M2

Pour lancer le projet :
1) Lancer le Naming Service (ajouter une entrée dans "Run Configuration" sous Eclipse --> cf CORBA_OpenORB.pdf)
2) Lancer une classe serveur (ajouter une entrée dans "Run Configuration" sous Eclipse --> cf CORBA_OpenORB.pdf)
3) Saisir au clavier le nom qui sera enregistré pour ce serveur
4) Lancer une classe cliente (ajouter une entrée dans "Run Configuration" sous Eclipse --> cf CORBA_OpenORB.pdf)
5) Saisir au clavier le nom du serveur à contacter


Remarques :
- L'erreur "org.omg.CORBA.UNKNOWN: Server Exception: Unregistered vendor exception" peut être due au fait que la méthode appelée ne retourne pas le type attendu.
- L'erreur "Caused by: org.omg.CORBA.COMM_FAILURE: Cannot connect to target" peut être due au fait que le Naming Service n'est pas démarré ou que sa configuration n'est pas bonne.
- Les "Run Configuration" d'Eclipse peuvent être sauvegardées (et gérées avec GitHub) dans des fichiers dédiés (cf http://stackoverflow.com/questions/8625060/store-run-configuration-with-project-in-eclipse)