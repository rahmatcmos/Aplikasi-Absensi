package com.rizki.mufrizal.aplikasi.absensi.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 7:17:46 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.domain
 *
 */
@Entity
@Table(name = "tb_asisten_role", indexes = {
    @Index(columnList = "id_asisten_role", name = "idAsistenRole"),
    @Index(columnList = "role", name = "role")
})
public class AsistenRole implements Serializable {

    @Id
    @Column(name = "id_asisten_role", length = 150)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String idAsistenRole;

    @Column(name = "role", length = 10)
    private String role = "ROLE_USER";

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "npm", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Asisten asisten;

    /**
     * @return the idAsistenRole
     */
    public String getIdAsistenRole() {
        return idAsistenRole;
    }

    /**
     * @param idAsistenRole the idAsistenRole to set
     */
    public void setIdAsistenRole(String idAsistenRole) {
        this.idAsistenRole = idAsistenRole;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the asisten
     */
    public Asisten getAsisten() {
        return asisten;
    }

    /**
     * @param asisten the asisten to set
     */
    public void setAsisten(Asisten asisten) {
        this.asisten = asisten;
    }

}
