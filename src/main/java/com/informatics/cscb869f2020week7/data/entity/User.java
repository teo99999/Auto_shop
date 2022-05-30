package com.informatics.cscb869f2020week7.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatics.cscb869f2020week7.web.view.model.AppointmentViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column
    private boolean isAccountNonExpired;

    @Column
    private boolean isAccountNonLocked;

    @Column
    private boolean isCredentialsNonExpired;

    @Column
    private boolean isEnabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Appointment> appointments;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;

   /* @ManyToOne
    @JoinColumn(name = "autoshop_id")
    private Autoshop autoshop;*/



}
