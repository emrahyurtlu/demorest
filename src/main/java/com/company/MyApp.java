package com.company;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/api")
public class MyApp extends Application {

    public void start() {
        System.out.println("Project is Started!");
    }

    /*
    *
    * Uygulama çalıştığında @Path anotasyonuna sahip sınıfları bulur ve resource olarak dışarıya açar.
    * Bu süreci siz yönetmek isterseniz getClasses() metodunu override ederek return kısmında gönderilecek olan
    * listeye sadece dışarıya açılmasını istediğiniz resource ları ekleyebilirsizi.
    *
    *
    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
    */
}

