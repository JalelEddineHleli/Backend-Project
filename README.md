# E-Commerce Product Management Backend

Ce projet est une application backend de gestion de produits pour une plateforme de e-commerce. Il a été développé avec **Spring Boot** et utilise plusieurs technologies modernes pour assurer une gestion efficace des produits, une sécurité renforcée, ainsi qu'une bonne documentation de l'API.

## Fonctionnalités principales

- **Gestion des produits** : 
   - L'API permet de gérer les produits, y compris l'ajout, la modification, la suppression et la consultation des produits dans la base de données.
   - Chaque produit est associé à une **catégorie** spécifique (par exemple, électronique, mode, etc.).
   - Des **détails supplémentaires** peuvent être ajoutés pour chaque produit, tels que des descriptions, des spécifications techniques, des images, etc.
   - Les utilisateurs peuvent laisser des **avis** sur chaque produit, permettant ainsi une meilleure évaluation de la qualité des produits par d'autres utilisateurs.
   - L'**administrateur** peut ajouter des **promotions automatiques** sur n'importe quel produit. Ces promotions peuvent inclure des réductions en pourcentage, des offres "2 pour 1", etc., et sont appliquées automatiquement au produit concerné.

- **Authentification et sécurité** : Utilisation de **JSON Web Tokens (JWT)** pour sécuriser les API et garantir l'accès uniquement aux utilisateurs authentifiés.
- **Documentation de l'API** : Documentation automatique de l'API avec **Swagger**, facilitant l'interaction avec l'API et la compréhension des endpoints disponibles.
- **Tests d'API avec Postman** : Des collections Postman sont fournies pour faciliter les tests des différentes fonctionnalités de l'API.

## Technologies utilisées

- **Spring Boot** : Framework principal pour le développement du backend.
- **JWT (JSON Web Token)** : Pour la gestion de l'authentification et de l'autorisation des utilisateurs.
- **Swagger** : Pour la documentation interactive et l'exploration des API.
- **Postman** : Pour tester et valider les endpoints de l'API.
- **Java 11+** : Langage de programmation utilisé pour le développement.
- **Spring Security** : Pour implémenter la sécurité du projet via l'authentification et la gestion des rôles.

## Fonctionnement de l'application

1. **Authentification** : 
   - L'utilisateur peut se connecter avec son nom d'utilisateur et son mot de passe pour obtenir un token JWT.
   - Ce token sera utilisé pour autoriser l'accès aux endpoints sécurisés de l'API.

2. **Gestion des produits** :
   - L'API permet d'ajouter, modifier, supprimer et consulter des produits dans la base de données.
   - Chaque produit est associé à une catégorie spécifique, et des détails supplémentaires peuvent être ajoutés.
   - Les utilisateurs peuvent laisser des avis sur les produits.

3. **Gestion des promotions** :
   - L'administrateur peut ajouter des promotions automatiques à n'importe quel produit.
   - Les promotions peuvent inclure des réductions ou des offres spéciales appliquées automatiquement au produit concerné.

4. **Swagger** :
   - La documentation de l'API est générée automatiquement par Swagger, ce qui permet une visualisation et un test faciles des endpoints.

