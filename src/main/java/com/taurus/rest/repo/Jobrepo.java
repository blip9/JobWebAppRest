package com.taurus.rest.repo;

import com.taurus.rest.model.Jobpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

@Repository
public interface Jobrepo extends JpaRepository<Jobpost,Integer>{
        List<Jobpost> findByPostDescContainingOrPostProfileContaining(String postDesc ,  String postProfile);

}
