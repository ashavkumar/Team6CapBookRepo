package com.cg.capbook.daoservices;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.capbook.beans.Album;
public interface AlbumDAO extends JpaRepository<Album, Integer>{
	@Query(value="select image from Album where email_id=?1")
	List<Byte[]> findbyName(String userEmailId);
}	