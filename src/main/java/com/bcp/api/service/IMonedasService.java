package com.bcp.api.service;

import java.util.List;

import com.bcp.api.domain.TipoMonedaProcRq;
import com.bcp.api.domain.TipoMonedaProcRs;
import com.bcp.api.domain.TipoMonedaRq;
import com.bcp.api.domain.TipoMonedaUpdRq;
import com.bcp.api.model.entity.MonedaEntity;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface IMonedasService {

	List<MonedaEntity> buscarTodos();
	
	Observable<MonedaEntity> listaTipoMoneda();
	
	Single<MonedaEntity> guarda(TipoMonedaRq tipMon);
	
	Single<MonedaEntity> actualiza(TipoMonedaUpdRq tipMon);
	
	Observable<TipoMonedaProcRs> procesa(TipoMonedaProcRq tipMon);
}
