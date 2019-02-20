package com.huangg.lock;

import org.springframework.stereotype.Service;

@Service
public class MyLock extends AbstractLock{

    private final static String getLock_sql="insert into tb_lock(id) values(1);";

    @Override
    public boolean getLock() {
        try{
            dblockJdbcTemplate.update(getLock_sql);
            return true;
        }catch (Exception e){
        }
        return false;
    }

    private final static String unLock_sql="delete from tb_lock where id=?";
    @Override
    public void unLock() {
        dblockJdbcTemplate.update(unLock_sql,new Object[]{1});
    }
}
