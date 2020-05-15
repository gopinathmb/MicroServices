/**
 * Created by gopinath_mb on 14-May-2020
 */
package com.gopi.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.microservices.limitsservice.bean.LimitConfiguration;

/**
 * @author gopinath_mb
 */
@RestController
public class LimitsConfigurationController
{
  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
public LimitConfiguration retrieveConfiguration() {
  
  return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
  
}
}
