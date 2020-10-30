package com.example.jdialectsdemo.dao;

import com.example.jdialectsdemo.entity.ProduceClass;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static org.hibernate.jpa.QueryHints.HINT_COMMENT;
import javax.persistence.QueryHint;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import java.util.List;

public interface ProduceClassDao extends JpaRepository<ProduceClass,Integer> {
    @QueryHints(value = { @QueryHint(name = HINT_COMMENT, value = "a query for pageable")})
    @Query(value = " select * from HS_PRODUCE_CLASS",nativeQuery = true)
    Page<ProduceClass> getPageList(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "delete from HS_PRODUCE_CLASS  WHERE Code=?1" ,nativeQuery = true)
    public void deleteByCode(String CODE);

    @Query(value = "SELECT  * FROM  HS_PRODUCE_CLASS  WHERE Code=?1" ,nativeQuery = true)
    public List<ProduceClass> findByCode(String CODE);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE HS_PRODUCE_CLASS h SET h.CLASS =?1 WHERE h.Code =?2 " ,nativeQuery = true)
    public int updatebycode(String CLASS,String CODE);


}
