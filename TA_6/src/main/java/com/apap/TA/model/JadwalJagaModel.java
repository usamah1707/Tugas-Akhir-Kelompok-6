package com.apap.TA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * JadwalJagaModel
 */
@Entity
@Table(name = "jadwal_jaga")
public class JadwalJagaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @NotNull
    @Column(name = "waktu_mulai", nullable = false)
    private Time waktu_mulai;

    @NotNull
    @Column(name = "waktu_selesai", nullable = false)
    private Time waktu_selesai;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private StaffModel staff;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Time getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(Time waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public Time getWaktu_selesai() {
        return waktu_selesai;
    }

    public void setWaktu_selesai(Time waktu_selesai) {
        this.waktu_selesai = waktu_selesai;
    }

    public StaffModel getStaff() {
        return staff;
    }

    public void setStaff(StaffModel staff) {
        this.staff = staff;
    }
}