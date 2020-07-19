/**
 * Created by gopinath_mb on 18-May-2020
 */
package com.gopi.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author gopinath_mb
 */
@RestController
public class CurrencyConversionController
{
  private Logger logger = LoggerFactory
      .getLogger(CurrencyConversionController.class);

  @Autowired
  private CurrencyExchangeServiceProxy proxy;

  @GetMapping("/currency-converer/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrency(@PathVariable String from,
      @PathVariable String to, @PathVariable BigDecimal quantity)
  {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);
    ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
        .getForEntity(
            "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
            CurrencyConversionBean.class, uriVariables);
    CurrencyConversionBean ccBean = responseEntity.getBody();
    BigDecimal conversionMultiple = ccBean.getConversionMultiple();
    return new CurrencyConversionBean(ccBean.getId(), from, to,
        conversionMultiple, quantity, quantity.multiply(conversionMultiple),
        ccBean.getPort());
  }

  @GetMapping("/currency-converer-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
      @PathVariable String to, @PathVariable BigDecimal quantity)
  {

    CurrencyConversionBean ccBean = proxy.retriveExchangeValue(from, to);
    BigDecimal conversionMultiple = ccBean.getConversionMultiple();
    logger.info(
        "In convertCurrencyFeign and converting {} with {} exchange rate.",
        quantity, conversionMultiple);
    return new CurrencyConversionBean(ccBean.getId(), from, to,
        conversionMultiple, quantity, quantity.multiply(conversionMultiple),
        ccBean.getPort());
  }

}
