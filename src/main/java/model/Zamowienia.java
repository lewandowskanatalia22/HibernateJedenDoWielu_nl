package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by jan on 2017-11-18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zamowienia")

public class Zamowienia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "listaArtykolow")
    private String listaArtykolow;

    @Column(name = "data_zamowienia")
    private LocalDate data_zamowienia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_uzytkownika", nullable=false)
    private Uzytkownik uzytkownik;
}
