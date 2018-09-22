package com.yukoon.midautumnquiz.repo;

import com.yukoon.midautumnquiz.entities.Result;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result,Integer> {

    @Query("select r from Result r where r.belongTo = :belongTo")
    public List<Result> findByBelongTo(@Param("belongTo")Integer belongTo);
}
