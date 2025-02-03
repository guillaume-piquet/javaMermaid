# Mermaid CLI Java

Ce projet est une implémentation en Java permettant de parser et de rendre des diagrammes Mermaid (simplifiés) en image.  
Il s'agit ici d'un outil en ligne de commande capable de lire un fichier texte contenant un diagramme de séquence écrit dans une syntaxe simplifiée, de le transformer en un modèle Java, puis de générer une image PNG grâce à Java2D.
pour  le moment ne gere  que  les diagrammes de sequences

## Fonctionnalités

- **Parsing** : Analyse d'un diagramme de séquence Mermaid et construction d'un modèle interne (`Diagram` et `SequenceLine`).
- **Rendu** : Génération d'une image PNG représentant le diagramme à l'aide de la bibliothèque Java2D.
- **Tests** : Ensemble de tests unitaires avec JUnit pour vérifier le comportement du parser et du renderer.

## Structure du projet

- `Diagram.java` : Classe représentant l'ensemble du diagramme (liste d'interactions).
- `SequenceLine.java` : Classe représentant une interaction (ligne) entre deux participants.
- `MermaidParser.java` : Classe responsable du parsing du texte Mermaid pour créer un objet `Diagram`.
- `Renderer.java` : Classe qui effectue le rendu graphique du diagramme en image PNG.
- `MermaidCliJava.java` : Application en ligne de commande qui lit un fichier source Mermaid, parse le contenu et génère l'image.
- `MermaidCliTest.java` : Classe de tests unitaires (JUnit) pour vérifier le parser et le renderer.

## Prérequis

- Java JDK 8 ou version ultérieure.
- (Optionnel) Maven pour exécuter les tests unitaires.

## Compilation

Pour compiler l'ensemble des classes, utilisez la commande suivante :

```bash
javac MermaidCliJava.java Diagram.java SequenceLine.java MermaidParser.java Renderer.java
