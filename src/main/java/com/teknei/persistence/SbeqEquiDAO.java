package com.teknei.persistence;

import com.teknei.config.ConfigurationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Amaro on 21/06/2017.
 */
@Component
public class SbeqEquiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sql = "Select id_equi from sitm_disp.sbeq_equi where id_esta = 1 order by fch_crea desc limit 1";

    @PostConstruct
    private void postConstruct(){
        Integer idEqui = jdbcTemplate.queryForObject(sql, Integer.class);
        ConfigurationHandler.getInstance().setIdEqui(idEqui);
    }

}
