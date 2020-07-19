/**
 * Created by gopinath_mb on 15-May-2020
 */
package com.gopi.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gopinath_mb
 */
@RestController
public class CurrencyExchangeController
{
  private Logger logger = LoggerFactory
      .getLogger(CurrencyExchangeController.class);

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeValueRepository repository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retriveExchangeValue(@PathVariable String from,
      @PathVariable String to)
  {

    ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
//    ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to,
//        BigDecimal.valueOf(65));
    logger.info("In retriveExchangeValue and exchange rate we got it {} .",
        exchangeValue);
    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));

    return exchangeValue;
  }
}
