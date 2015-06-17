package com.thinkful.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLEMODEL")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;

    public VehicleModel() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VehicleModel)) return false;
        final VehicleModel other = (VehicleModel) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.id != other.id) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.id;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehicleModel;
    }

    public String toString() {
        return "com.thinkful.spring.entity.VehicleModel(id=" + this.id + ", name=" + this.name + ")";
    }
}
