package com.huangg.lock;

import com.huangg.dao.impl.BaseDao;

public  abstract class AbstractLock extends BaseDao implements Lock {

    public abstract boolean getLock();

    public abstract void unLock();
}
