package com.chechpoint2JAVA.java2;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
@SequenceGenerator(name = "brinquedo_sequence", sequenceName = "BRINQUEDO_SEQ", allocationSize = 1)
@Data
@NoArgsConstructor
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brinquedo_sequence")
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    @Column(name = "CLASSIFICACAO", nullable = false)
    private String classificacao;

    @Column(name = "TAMANHO", nullable = false)
    private String tamanho;

    @Column(name = "PRECO", nullable = false)
    private BigDecimal preco;
}
