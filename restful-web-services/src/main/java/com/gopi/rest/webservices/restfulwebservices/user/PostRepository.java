/**
 * Created by gopinath_mb on 14-May-2020
 */
package com.gopi.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gopinath_mb
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>
{

}
