package com.bcp.api.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TipoMonedaProcRs {
	
	private String monedaorigen;
	private String monedadestino;
	private BigDecimal monto;
	private BigDecimal montoCambio;
	
}
