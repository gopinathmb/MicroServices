/**
 * Created by gopinath_mb on 10-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author gopinath_mb
 */
@ApiModel(description = "This is Pojo class for User.")
@Entity
public class User
{
  @Id
  @GeneratedValue
  private Integer id;

  //atleast 2 characters. 
  @Size(min = 2, message = "Name should be atleast 2 characters. This appear in post request when user try to create User.")
  @ApiModelProperty(notes = "Name should be atleast 2 characters. This will appear in swagger doc")
  private String name;

  //BirthDate should be past date
  @Past
  @ApiModelProperty(notes = "BirthDate should be in Past. This will appear in swagger doc")
  private Date birthDate;

  public User()
  {
    
  }
  /**
   * @param id
   * @param name
   * @param birthDate
   */
  public User(Integer id, String name, Date birthDate)
  {
    super();
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  /**
   * @return the id
   */
  public Integer getId()
  {
    return id;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(Integer id)
  {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * @return the birthDate
   */
  public Date getBirthDate()
  {
    return birthDate;
  }

  /**
   * @param birthDate
   *          the birthDate to set
   */
  public void setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
  }

  @Override
  public String toString()
  {
    return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate
        + "]";
  }

}
