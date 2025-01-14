package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "menu")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    @EqualsAndHashCode.Include
    private Integer id_menu;

    @Column(nullable = false, length = 20)
    private String icon;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_privilegio",
            joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "id_menu"),
            inverseJoinColumns = @JoinColumn(name = "id_privilegio", referencedColumnName = "id_privilegio")
    )
    private List<Privilegio> roles;
}
