package com.bcp.api.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.domain.TipoMonedaProcRq;
import com.bcp.api.domain.TipoMonedaProcRs;
import com.bcp.api.domain.TipoMonedaRq;
import com.bcp.api.domain.TipoMonedaUpdRq;
import com.bcp.api.model.entity.MonedaEntity;
import com.bcp.api.repository.MonedasRepository;
import com.bcp.api.service.IMonedasService;
//import com.bcp.api.service.impl.mapper.TipoMonedaMapper;

import io.reactivex.Observable;
import io.reactivex.Single;
//import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class MonedasServiceImpl implements IMonedasService {

	@Autowired
	private MonedasRepository repoMonedas;
	
//	@Autowired
//	private final TipoMonedaMapper tipoMonedaMapper;
	
	@Override
	public List<MonedaEntity> buscarTodos() {

		return repoMonedas.findAll();
	}

	@Override
	public Observable<MonedaEntity> listaTipoMoneda() {
		
		return Observable.fromIterable(repoMonedas.findAll());
	}
	
    @Override
    public Single<MonedaEntity> guarda(TipoMonedaRq tipMon) {
        return Single.just(repoMonedas.save(mapSave.apply(tipMon)));
    }
    
//    @Override
//    public Single<MonedaEntity> guarda(TipoMonedaRq tipMon) {
//        return Single.just(repoMonedas.save(tipoMonedaMapper.mapMoneda(tipMon)));
//    	
//    }
    
    @Override
    public Single<MonedaEntity> actualiza(TipoMonedaUpdRq tipMon) {
        return Single.just(repoMonedas.save(mapUpdate.apply(tipMon)));
    } 
      
	@Override
	public Observable<TipoMonedaProcRs> procesa(TipoMonedaProcRq request) {
      return Observable.just(request)
    		  .flatMap(req -> Objects.isNull(repoMonedas.findByMonedaorigenAndMonedadestino(
              req.getMonedaorigen(), req.getMonedadestino())) ? Observable.empty() : Observable.just(
            		  repoMonedas.findByMonedaorigenAndMonedadestino(
                      req.getMonedaorigen(), req.getMonedadestino()))
              .switchIfEmpty(Observable.error(new Throwable("Error")))
              .take(1)
              .flatMap(entity -> procesaMonto.apply(req.getMonto(), entity)));
	}
    
    private Function<TipoMonedaRq, MonedaEntity> mapSave = tipMon -> MonedaEntity.builder()
										            		.monedaorigen(tipMon.getMonedaorigen())
										                    .monedadestino(tipMon.getMonedadestino())
										                    .equivalencia(tipMon.getEquivalencia())
										                    .build();
            
    private Function<TipoMonedaUpdRq, MonedaEntity> mapUpdate = tipMon -> MonedaEntity.builder()
											                    .idtipocambio(tipMon.getIdtipocambio())
											                    .monedaorigen(tipMon.getMonedaorigen())
											                    .monedadestino(tipMon.getMonedadestino())
											                    .equivalencia(tipMon.getEquivalencia())
											                    .build();
            
    private BiFunction<BigDecimal, MonedaEntity, Observable<TipoMonedaProcRs>> procesaMonto =
            (amount, entity) -> Observable.just(TipoMonedaProcRs.builder()
                    .monto(amount)
                    .montoCambio(amount.multiply(entity.getEquivalencia()))
                    .monedaorigen(entity.getMonedaorigen())
                    .monedadestino(entity.getMonedadestino())
                    .build());
           

}
