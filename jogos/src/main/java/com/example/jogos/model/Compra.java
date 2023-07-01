package com.example.jogos.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    Date data;
    float precoTotal;

    //caso 3
    @ManyToOne
	@JoinColumn(name = "fk_usuario")
	Usuario usuario;

    //caso 1
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compra_jogo", joinColumns = { @JoinColumn(name ="fk_compra", referencedColumnName = "id") }, inverseJoinColumns = {
    @JoinColumn(name = "fk_jogo") })
    List<Jogo> jogo;
}
