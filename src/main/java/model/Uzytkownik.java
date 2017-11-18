package model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="uzytkownik")

public class Uzytkownik {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_uzytkownika")
    private int id_uzytkownika;

    @Column(name = "imie_uzytkownika")
    private String imieuzytkownika;

    @Column(name = "nazwisko_uzytkownika")
    private String nazwiskouzytkownika;

    @Column(name = "aders_uzytkownika")
    private String adresuzytkownika;

    @OneToMany(mappedBy="uzytkownik", cascade = CascadeType.ALL)
    private List<Zamowienia> listaArtykolow = new ArrayList<Zamowienia>();
}
