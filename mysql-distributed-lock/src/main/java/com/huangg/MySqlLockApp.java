package com.huangg;

import com.huangg.lock.Th;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySqlLockApp implements CommandLineRunner
{

    @Autowired
    Th th;

    public static void main( String[] args )
    {
        SpringApplication.run(MySqlLockApp.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Thread[] threads=new Thread[10];
         for(int i=0;i <10;i++){
             threads[i]=new Thread(th);
             threads[i].setName("T"+(i<10? "0"+i:i));
             threads[i].start();
         }

    }

}
