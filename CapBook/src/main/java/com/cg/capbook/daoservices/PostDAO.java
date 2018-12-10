package com.cg.capbook.daoservices;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Post;
public interface PostDAO extends JpaRepository<Post, Integer>{
	@Query(value="SELECT * FROM POST WHERE email_id=?1",nativeQuery=true)
	List<Post> findPost(String sessionEmailId);
}
