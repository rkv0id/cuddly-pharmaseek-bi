package com.dminers.pharmabi.internalprods.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Article {

    private @Id int idArticle;
    private String categorie;
    private String designation;
    private String dci1;
    private String dci2;
    private String dci3;

}
