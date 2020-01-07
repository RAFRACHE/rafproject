package com.gkemayo.Library01.customer;
/*=========================LES DTOs=====================
DTO qui veut dire "Data Transfer Object" sont des objets qui vont contenir les données en tant que tel
 (exemple le DTO Client qui va contenir des propriété genre Nom, Prenom, Adresse, etc). Ils ne contiennent
  généralement pas de "logique métier"
DAO qui veut dire "Data Access Object" est ce qui va contenir les méthodes permettant de récupérer, insérer, mettre a jour,
 effacer tes DTOs dans le système de stockage (BD, Fichiers, etc.)
 =============================
* On commence par le plus simple, le DTO (Data Transfer Object) :
C'est un objet qui défini la structure des informations à échanger, généralement, Serializable.
En gros, c'est l'objet qui circule entre les différentes couches de ton application.

Le DAO (Data Access Object) :
C'est l'objet qui contient les méthodes d'accès aux données de la base de données.
On peut utiliser JDBC ou JPA ou Hibernate (ou autre ORM) pour le faire mais c'est bien cette classe qui s'en occupe.
On y retrouve généralement les méthodes de base :
- create(...) pour créer un enregistrement en DB
- update(...) pour modifier un enregistrement existant en DB
- delete(...) pour supprimer l'enregistrement en DB
- findAll(...) pour récupérer la liste des enregistrements correspondant aux critères
- get(...) (ou find(...)) pour récupérer l'enregistrement sur sa clé primaire

Les paramètres de ces méthodes dépendent un peu de la technologie, avec JPA on serait tenté d'avoir un entity en paramètre
mais on pourrait systématiquement utiliser le DTO :
- create(dto)
- upate(dto)
- delete(dto)
- List<dto> findAll(... liste des filtres de requête)

Bref, le DAO est un peu plus compliqué que le DTO
* */

import java.time.LocalDate;
//Swagger
//https://rdonfack.developpez.com/tutoriels/documenter-web-api-aspnet-core-swagger/
/*C'est pour répondre à ce besoin que des développeurs ont mis en place le projet Swagger. Il s'agit d'un Framework qui
 offre des outils permettant de générer de la documentation pour son API Web. Il offre également une interface permettant
  d'explorer et tester les différentes opérations offertes par le service.*/
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
// pour comprender les annotaions de swagger
//https://github.com/swagger-api/swagger-core/wiki/Annotations
@ApiModel(value = "Customer Model")
//	Fournit des informations supplémentaires sur les modèles Swagger.
public class CustomerDTO implements Comparable<CustomerDTO>{
    //y	Ajoute et manipule les données d'une propriété de modèle
    @ApiModelProperty(value = "Customer id")
    private Integer id;

    @ApiModelProperty(value = "Customer first name")
    private String firstName;

    @ApiModelProperty(value = "Customer last name")
    private String lastName;

    @ApiModelProperty(value = "Customer job")
    private String job;


    

    @ApiModelProperty(value = "Customer address")
    private String address;

    @ApiModelProperty(value = "Customer email")
    private String email;

    @ApiModelProperty(value = "Customer creation date in the system")
    private LocalDate creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int compareTo(CustomerDTO o) {
        return this.lastName.compareToIgnoreCase(o.getLastName());
    }

}
