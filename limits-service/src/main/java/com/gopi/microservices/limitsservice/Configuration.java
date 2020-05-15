/**
 * Created by gopinath_mb on 15-May-2020
 */
package com.gopi.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gopinath_mb
 */
@Component
@ConfigurationProperties("limits-service") // Read all properties which starts prefix limit-service and suffix as class member.
public class Configuration
{
  private int minimum;

  private int maximum;

  /**
   * @return the minimum
   */
  public int getMinimum()
  {
    return minimum;
  }

  /**
   * @param minimum
   *          the minimum to set
   */
  public void setMinimum(int minimum)
  {
    this.minimum = minimum;
  }

  /**
   * @return the maximum
   */
  public int getMaximum()
  {
    return maximum;
  }

  /**
   * @param maximum
   *          the maximum to set
   */
  public void setMaximum(int maximum)
  {
    this.maximum = maximum;
  }

}
