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



XXXXXXXXXXXXXXXXXXXXXXXXXX



### Spécificités

Le script de création de la base de donnée est disponible dans les fichiers sources. Cependant, une base de donnée en ligne est disponible pour l'application. 

> ```json
> password: BuyMyBag69
> username : root
> url: jdbc:mysql://buymybag.ck8e4ot53w8k.eu-central-1.rds.amazonaws.com:3306/website_shop_db?serverTimezone=UTC&useLegacyDatetimeCode=false
> ```



