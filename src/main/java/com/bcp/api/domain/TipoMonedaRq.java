package com.bcp.api.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoMonedaRq {
	private String monedaorigen;
	private String monedadestino;
	private BigDecimal equivalencia;
	
}
