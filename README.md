# To-Do 

- [ ] Intégrer les observers (méthodes + attributs) dans les modèles 

# Methode de travail

La branche ``main`` est la branche "production".

Pour chaque semaine, une branche ``rendu<numéro de semaine>`` est crée, c'est une branche "release".

Les fonctionnalité sont codées dans une branche ``feature-<Nom>`` avant d'être merge request à la branche ``rendu`` puis enfin au ``main``.

# Inscryption

## Architecture 

Utilisation de l'architecture [MVC](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller). 

Pour les modèles représentant les cartes, utilisation du design pattern [decorator](https://en.wikipedia.org/wiki/Decorator_pattern) pour supporter la superposition de modifiers (volant, etc...) sans ajouter de nouvelles classes. 
