package com.bcp.api.model.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "monedas")
public class MonedaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idtipocambio;

	private String monedaorigen;

	private String monedadestino;

	private BigDecimal equivalencia;



}
