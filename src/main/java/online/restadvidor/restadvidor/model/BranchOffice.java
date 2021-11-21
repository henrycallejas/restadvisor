package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "branchOffice")

public class BranchOffice {

    private long branchId;
    private String address;
    private String department;
    private String municipality;
    private int restaurantId;

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public BranchOffice(long branchId, String address, String department, String municipality, int restaurantId) {
        this.branchId = branchId;
        this.address = address;
        this.department = department;
        this.municipality = municipality;
        this.restaurantId = restaurantId;
    }
}
