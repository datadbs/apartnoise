package com.apartnoise.persist;

import com.apartnoise.model.Apart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartRepository extends JpaRepository<Apart, Long> {

    List<Apart> findByApartnameLikeOrderByIDDesc(String name);

}