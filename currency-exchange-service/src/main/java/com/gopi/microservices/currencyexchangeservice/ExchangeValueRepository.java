/**
 * Created by gopinath_mb on 16-May-2020
 */
package com.gopi.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gopinath_mb
 */
public interface ExchangeValueRepository
    extends JpaRepository<ExchangeValue, Long>
{

  // Here jpa itself will take care of generating the query based on method names.
  public ExchangeValue findByFromAndTo(String from, String to);
}
