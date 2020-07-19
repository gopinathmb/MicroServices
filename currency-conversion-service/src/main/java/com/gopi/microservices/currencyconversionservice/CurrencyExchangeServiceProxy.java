/**
 * Created by gopinath_mb on 18-May-2020
 */
package com.gopi.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gopinath_mb
 */
//@FeignClient(name = "currency-exchange-service")   //This is for normal Feign client but if u r using API gateway u should provide api gateway
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{
  //@GetMapping("/currency-exchange/from/{from}/to/{to}") //For normal Feign Client
  @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") //Through API GateWay
  public CurrencyConversionBean retriveExchangeValue(
      @PathVariable("from") String from, @PathVariable("to") String to);
}
