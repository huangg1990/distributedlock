package com.huangg.lock;

import com.huangg.dao.DataNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Th implements Runnable {

    @Autowired
    MyLock myLock;

    @Override
    public void run() {
        try {
            while (true) {
                if (DataNumber.NUMBER >= 100) {
                    return;
                }
                boolean lock = myLock.getLock();
                if (lock) {
                    //System.out.println(Thread.currentThread().getName() + ":成功获取到锁" );

                    DataNumber.NUMBER++;
                    System.out.println(Thread.currentThread().getName() + ":" + DataNumber.NUMBER);
                    myLock.unLock();
                } else {
                    //System.out.println(Thread.currentThread().getName() + ":未获取到锁" );
                    Thread.sleep(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myLock.unLock();
        }

    }


//    @Override
//    public void run() {
//        while (true){
//            if (DataNumber.NUMBER >= 100) {
//                return;
//            }
//            DataNumber.NUMBER++;
//            System.out.println(Thread.currentThread().getName() + ":" + DataNumber.NUMBER);
//        }
//    }


}
