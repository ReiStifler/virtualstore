package br.iesb.store.virtualstore.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class CupomEntity extends PrincipalEntity {

    private String code; // HappyNewYear

    private Integer valor;

    private Date inicio;

    private Date fim;
}
