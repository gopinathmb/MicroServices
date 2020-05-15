/**
 * Created by gopinath_mb on 14-May-2020
 */
package com.gopi.microservices.limitsservice.bean;

/**
 * @author gopinath_mb
 */
public class LimitConfiguration
{
  private int minimum;

  private int maximum;

  /**
   * @param minimum
   * @param maximum
   */
  public LimitConfiguration(int maximum, int minimum)
  {
    super();
    this.maximum = maximum;
    this.minimum = minimum;
  }

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
