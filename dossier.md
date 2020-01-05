# <img src="https://i.ibb.co/s6XhbxM/shopping-bag.png" style="zoom:20%;" />Buy My Bag (Dossier)

## Présentation 

*Buy My Bag* est un site de vente en ligne de sacs.  Les sacs sont répartis en fonction de leurs catégories 

 */* : (**Home**): page d'accueil du site, reprenant tous les produits et les promotions en cours 

*/category/<NOM_CATEGORIE>* : **Catégories** : chaque catégorie possède une page qui reprends tous les articles de cette catégorie. 

*/detail/<NOM_ARTICLE>* : **Article** : Chaque produit possède une page d'où on peut ajouter au panier un article. 

## Catégories 

* Sacs à dos 
* Sacs cabas
* Sacs de voyage
* Sacs en bandoulières
* Trousses

## Promotions

Les promotions s'effectuent sous la forme d'une réduction générale appliquée sur tous les articles en fonction de la date de la commande. 

<img src="https://i.ibb.co/SJyYQhN/reduction-Janvier.png" alt="Promo"/>

## Base de donnée 

### Schéma Entité-associations 

#### Description des tables

##### user

* **username** : username de l'utilisateur
* password : mot de passe de l'utilisateur
* email : email de l'utilisateur
* streetname : nom de rue du client
* gender : genre de l'utilisateur
* first_name : prenom de l'utilisateur
* last_name : nom  de l'utilisateur
* locality : localité de l'utilisateur
* phone_number : numéro de téléphone de l'utilisateur
* authorities : rôles de l'utilisateur
* non_expired : utilisateur encore valide
* non_locked : utilisateur non kick
* credentials_non_expired : utilisateur pas expiré
* enabled : compté actif

##### clientorder

* **Primary Key**

* creation_date : date de création de l'order
* *user_login* :(fk): login de la personne qui à passé la commande 
* is_payed : si la commande à été payé

##### category

* **name** : nom de la catégorie

##### language

* **language** : nom de la langue

##### product

* **name** : nom du produit

* price : prix de vente du produit
* *category_name* : nom de la catégorie 

##### translation

* **Primary key**

* *language* :(fk): langue dans laquelle la desciption est effectuée 
* product_description : traduction de la description du produit
* *product* :(fk): traduction du nom du produit

##### image

* **Primary key**

* image_uri : lien de l'image
* *category_name* :(fk): nom de la catégorie
* *product_name* :(fk): nom du produit

##### orderline

* **Primary Key**

* quantity : quantité de l'article
* price : prix de l'article
* *orderid* :(fk): id de la commande
* *product_name* :(fk): nom de l'article 

##### promotion

* **event_name** : nom de l'événement

* event_start_date : date de départ de la promo 

* event_end-price_for_date : date de fin de la promo 
* min_order_price _for_application : prix minimum d'achat pour prétendre à la réduction
* reduction_prct : pourcentage de réduction

#### Schéma de bases de données

![](C:\Users\Antoine Lambert\Downloads\web328DBSchema.jpg)

### Spécificités

Le script de création de la base de donnée est disponible dans les fichiers sources. Cependant, une base de donnée en ligne est disponible pour l'application. 

> ```json
> password: BuyMyBag69
> username : root
> url: jdbc:mysql://buymybag.ck8e4ot53w8k.eu-central-1.rds.amazonaws.com:3306/website_shop_db?serverTimezone=UTC&useLegacyDatetimeCode=false
> ```



