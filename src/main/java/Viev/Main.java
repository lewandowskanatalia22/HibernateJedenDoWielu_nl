package Viev;

import model.Uzytkownik;
import model.Zamowienia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

/**
 * Created by jan on 2017-11-18.
 */
public class Main {
    public static void main(String[] args) {

        Uzytkownik uzytkownik1= new Uzytkownik();
        uzytkownik1.setImieuzytkownika("Natalia");
        uzytkownik1.setAdresuzytkownika("ul.");
        uzytkownik1.setNazwiskouzytkownika("LEwa");

        Zamowienia zamowienia1=new Zamowienia();
        zamowienia1.setListaArtykolow("Car");

        Zamowienia zamowienia2=new Zamowienia();
        zamowienia2.setListaArtykolow("bike");
        zamowienia2.setData_zamowienia(LocalDate.now());

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(uzytkownik1);

        zamowienia1.setUzytkownik(uzytkownik1);
        zamowienia2.setUzytkownik(uzytkownik1);

        session.save(zamowienia1);
        session.save(zamowienia2);
        session.getTransaction().commit();
        session.close();
    }
}
