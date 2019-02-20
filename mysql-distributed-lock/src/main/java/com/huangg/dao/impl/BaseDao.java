package com.huangg.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDao  {
    @Autowired
    @Qualifier("dblockJdbcTemplate")
    protected JdbcTemplate dblockJdbcTemplate;
}
