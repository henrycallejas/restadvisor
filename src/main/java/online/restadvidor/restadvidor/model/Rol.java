package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "rol")

public class Rol {

    private long rolId;
    private String nameRol;

    public long getRolId() {
        return rolId;
    }

    public void setRolId(long rolId) {
        this.rolId = rolId;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public Rol(long rolId, String nameRol) {
        this.rolId = rolId;
        this.nameRol = nameRol;
    }
}
