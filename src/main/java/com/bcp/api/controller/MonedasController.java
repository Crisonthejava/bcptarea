package com.bcp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.domain.TipoMonedaProcRq;
import com.bcp.api.domain.TipoMonedaProcRs;
import com.bcp.api.domain.TipoMonedaRq;
import com.bcp.api.domain.TipoMonedaUpdRq;
import com.bcp.api.model.entity.MonedaEntity;
import com.bcp.api.service.IMonedasService;

import io.reactivex.Observable;
import io.reactivex.Single;

@RestController
@RequestMapping("/api")
public class MonedasController {
	
	@Autowired
	private IMonedasService serviceMonedas;
	
    @GetMapping("/listar")
    public Observable<MonedaEntity> lista() {
    	return serviceMonedas.listaTipoMoneda();
    }
    
    @PostMapping("/guardar")
    public Single<MonedaEntity> guarda(@RequestBody TipoMonedaRq tipMon) {
        return serviceMonedas.guarda(tipMon);
    }
    
    @PutMapping("/actualizar")
    public Single<MonedaEntity> actualiza(@RequestBody TipoMonedaUpdRq tipMon) {
        return serviceMonedas.actualiza(tipMon);
    }
	
    @PostMapping(value = "/procesar", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Observable<TipoMonedaProcRs> procesa(@RequestBody TipoMonedaProcRq tipMon) {
        return serviceMonedas.procesa(tipMon);
    }

}
