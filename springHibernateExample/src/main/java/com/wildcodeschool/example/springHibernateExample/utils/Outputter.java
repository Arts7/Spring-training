package com.wildcodeschool.example.springHibernateExample.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.wildcodeschool.example.springHibernateExample.entities.User;
import com.wildcodeschool.example.springHibernateExample.repositories.UserDao;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");
    
    @Autowired
    private UserDao UserDao;

    @Override
    public void run(String... args) throws Exception {
        
        LOG.info("*****************");
        LOG.info("Objects in DB : " + UserDao.count());

        User user1 = new User("BobLe", "Bricoleur", 45);
        LOG.info("*****************");
        LOG.info(user1 + " has been created !");
        UserDao.save(user1);
        LOG.info(user1 + " has been savec ! ");

        User user2 = new User("Boby", "poivrot", 75);
        LOG.info("******************");
        LOG.info(user2 + " has been created !");
        UserDao.save(user2);
        LOG.info(user2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        User tempUser = UserDao.findById(2L).get(); /*
                                                     * On écrit "2L" car le type de l'id est Long
                                                     */
        LOG.info("******************");
        LOG.info("Second user's firstName is " + tempUser.getFirstName());
        LOG.info("Second user's lastName is " + tempUser.getLastName());
        LOG.info("Second user's age is " + tempUser.getAge());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Users in list are ");
        for (User myUser : UserDao.findAll()) {
            LOG.info(myUser.toString());
        }
        ;

        // Supprime le second utilisateur de la BDD
        UserDao.deleteById(2L); /*
                                 * risque de provoquer une erreur si tu n'as pas vidé ta table avant de relancer
                                 * ton application !
                                 */

        /*
         * Liste les utilisateurs enregistrés dans la BDD (permet de vérifier que le
         * second utilisateur a bien été supprimé de la BDD)
         */
        LOG.info("******************");
        LOG.info("Users in list are ");
        for (User myUser : UserDao.findAll()) {
            LOG.info(myUser.toString());
        };
    }
}