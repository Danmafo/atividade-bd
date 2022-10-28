package br.com.atividade.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("atividade-jpa-bd");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
