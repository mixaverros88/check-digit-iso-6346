package com.verros.ds.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="chechDigit")
public class CheckDigit implements Serializable {


    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;


    @Column(name = "digit" )
    private String digit;

    public CheckDigit() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

}
