package com.bcp.api.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TipoMonedaProcRq {

	private String monedaorigen;
	private String monedadestino;
	private BigDecimal monto;
	
	
}
