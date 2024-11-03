# *MUT*: manage your time 
## Gestion des livraisons et transporteurs 
- *Objectif du projet*:

Ce projet vise à simplifier et automatiser la gestion des livraisons en offrant aux entreprises une plateforme intuitive pour suivre et organiser leurs livraisons, réduisant ainsi les coûts et les erreurs. Il permet une gestion optimisée des processus logistiques, assurant transparence et fiabilité. Ce projet est développé en utilisant Spring Boot, garantissant une architecture évolutive et performante.
## Structure du projet 
__Le projet est organisé de la manière suivante__ :

![image](https://github.com/user-attachments/assets/a7faf138-6c79-458c-bae6-d47a8123e2c2)        ![image](https://github.com/user-attachments/assets/aa1cb307-8d69-4dee-be6e-67c5953e1538)




- `controller`: *Ce package contient les contrôleurs qui gèrent les interactions avec l'utilisateur via l'interface Web (par exemple, les pages HTML, les formulaires, etc.).*

- `entity`: *Ce package contient les classes représentant les différents types d'entités de notre  application (Livraison, Transporteur, etc.). Il s'agit des classes qui sont mappées à la base de données*.

- `repository`: *Ce package contient les interfaces de repository qui définissent les méthodes pour interagir avec la base de données. Ces méthodes sont généralement utilisées par les services métier pour accéder aux données*.

- `service`: *Ce package contient les classes de service métier qui encapsulent la logique métier de l'application. Les services interagissent avec les repositories pour accéder aux données et implémentent la logique spécifique au domaine des livraisons.*
- `templates` : *pour la partie front-end présente les pages de l'interface principale.*

## Outils  utilisées
#### *Back-end* ,*Front-end*
- `Spring Boot` : *Framework Java pour le développement d'applications web*.
- `Spring Data JPA` : *Simplifie l'accès aux données via JPA*.
- `MySQL`: *Base de données relationnelle pour stocker les données*.
- `Thymeleaf` : *Moteur de template pour la création de pages web dynamiques*.
- `Lombok` :  *Librairie permettant de réduire le code boilerplate*.
- `Maven` : *Gestionnaire de dépendances pour la compilation et le packaging du projet*
- `Ajax` : *Technique permettant de charger des données dynamiquement sans recharger la page entière, améliorant la réactivité et l'expérience utilisateur*.
- `Html` : *Langage de balisage standard pour structurer le contenu et le layout des pages web.*
- `JavaScript` : *Langage de programmation côté client pour l'interactivité* 
- `Css` : *Langage utilisé pour styliser les éléments HTML et définir l'apparence visuelle de l'application*.
- `BootStarp` : *Framework CSS populaire offrant une mise en page et un style cohérents et réactifs pour les pages web, simplifiant le processus de création d'une interface utilisateur attrayante*.
- `Font Awesome` : *Bibliothèque d'icônes vectorielles pour ajouter des icônes visuelles aux pages web, améliorant la clarté et l'attrait de l'interface.*
  
 ## fonctionnalité utilisées
- ajouter une livraison  : *Crée et enregistre une nouvelle livraison avec détails et transporteur assigné.*
- ajouter un transporteur : *Enregistre un transporteur avec ses informations pour l’affectation aux livraisons*.
- liste des livraisons : *Affiche toutes les livraisons pour un suivi global.*
- listes des transporteurs  : *Affiche tous les transporteurs enregistrés.*
- recherche dynamic par nom   pour un transporteur donnée en utulisons Ajax :  *Recherche instantanée de transporteurs par nom,Permet de rechercher un transporteur en temps réel sans rechargement de page.*
- recherche des livraisons pour une date donnée : *Filtre les livraisons pour une date spécifique, facilitant la planification.*
- afficher les livraisons avec le transporteur associeé : *Montre les livraisons en incluant le transporteur responsable pour une meilleure traçabilité.*
- afficher les livraisons effectuées par un transporteur spécifique : *Liste toutes les livraisons effectuées par un transporteur, permettant d’évaluer sa performance.*


## Diagramme de classe 
- relation `OneToMany` , `ManyToOne` 
![image](https://github.com/user-attachments/assets/3d140c3b-c694-494a-b56e-29fa3e1e53c1)


### Entites utulisée
- `Livraison` : (utulisation des contraintes de validation pour l'adresse)
  
*N.B*: les messages d'obligatition en raisons des contraintes

![image](https://github.com/user-attachments/assets/8ea723a0-b75e-46b8-8a1e-6d806733d3a0)

- `transporteur`:(utulisation des contraintes de validation pour le nom du transporteur)
  
*N.B*: la fonctionnalité d'affichage  des livraisons effectuées par un transporteur spécifique

  ![image](https://github.com/user-attachments/assets/41c1616f-0158-4b55-a089-997ca916e99d)

## Démonstration :


https://github.com/user-attachments/assets/f05a7c65-f6e9-4d36-b5e7-9283d0ef8a84








  







## Auteurs
' Errokbi oumaima '
  
  

