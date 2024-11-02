# Controle 
# Projet :gestion des livraisons et transporteurs 
## Objectif du projet 
Ce projet vise à simplifier et automatiser la gestion des livraisons en offrant une plateforme intuitive et fiable.
L'objectif est de permettre aux entreprises de suivre et de gérer efficacement leurs livraisons, réduisant ainsi les coûts et les erreurs.
## Structure du projet 
Le projet est organisé de la manière suivante :

![image controle chagr](https://github.com/user-attachments/assets/5c3f6ac1-dfff-40f2-8024-16d4bf6b4a64)   


- controller: Ce package contient les contrôleurs qui gèrent les interactions avec l'utilisateur via l'interface Web (par exemple, les pages HTML, les formulaires, etc.).

- entity: Ce package contient les classes représentant les différents types d'entités de notre  application (Livraison, Transporteur, etc.). Il s'agit des classes qui sont mappées à la base de données.

- repository: Ce package contient les interfaces de repository qui définissent les méthodes pour interagir avec la base de données. Ces méthodes sont généralement utilisées par les services métier pour accéder aux données.

- service: Ce package contient les classes de service métier qui encapsulent la logique métier de l'application. Les services interagissent avec les repositories pour accéder aux données et implémentent la logique spécifique au domaine des livraisons.
- templates : pour la partie front-end présente les pages de l'interface principale.

## Outils  utilisées
#### Back-end  ,Front-end
- `Spring Boot` : Framework Java pour le développement d'applications web.
- `Spring Data JPA` : Simplifie l'accès aux données via JPA.
- `MySQL`: Base de données relationnelle pour stocker les données.
- `Thymeleaf` : Moteur de template pour la création de pages web dynamiques.
- `Lombok` :  Librairie permettant de réduire le code boilerplate.
- `Maven` : Gestionnaire de dépendances pour la compilation et le packaging du projet
- `Ajax` : Technique permettant de charger des données dynamiquement sans recharger la page entière, améliorant la réactivité et l'expérience utilisateur.
- `Html` : Langage de balisage standard pour structurer le contenu et le layout des pages web.
- `JavaScript` : Langage de programmation côté client pour l'interactivité, 
- `Css` : Langage utilisé pour styliser les éléments HTML et définir l'apparence visuelle de l'application.
- `BootStarp` : Framework CSS populaire offrant une mise en page et un style cohérents et réactifs pour les pages web, simplifiant le processus de création d'une interface utilisateur attrayante.
- `Font Awesome` : Bibliothèque d'icônes vectorielles pour ajouter des icônes visuelles aux pages web, améliorant la clarté et l'attrait de l'interface.
  
 ## fonctionnalité utilisées
- ajout d'une livraison ou d'un transporteur 
- liste des livraisons et des transporteurs
- recherche dynamic par nom   pour un transporteur donnée en utulisons Ajax 
- recherche des livraisons pour une date donnée
- afficher les livraisons avec le transporteur associeé
- afficher les livraisons effectuées par un transporteur spécifique
## Diagramme de classe 
- relation `OneToMany` , `ManyToOne` 
![diagrame chgar](https://github.com/user-attachments/assets/69c0bd49-479e-46de-9161-b174c463d62b)

### Entites utulisée
- `Livraison` : (utulisation des contraintes de validation pour l'adresse)
- `transporteur`:(utulisation des contraintes de validation pour le nom du transporteur)
## Test 
`N.B` : les messages d'obligatition en raisons des contraintes  

![vamidation](https://github.com/user-attachments/assets/1ba2c758-dea7-4913-a45b-adfc48d0bab7)

`N.B` : la fonctionnalité d'affichage  des livraisons effectuées par un transporteur spécifique

![image](https://github.com/user-attachments/assets/41c1616f-0158-4b55-a089-997ca916e99d)





  
## démonstration 



https://github.com/user-attachments/assets/f1c3f227-ae31-4266-85b8-64482bc34c85



## Auteurs
' Errokbi oumaima '
  
  

