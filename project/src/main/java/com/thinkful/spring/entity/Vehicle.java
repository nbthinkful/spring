package com.thinkful.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(targetEntity = VehicleModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiclemodel_id")
    private VehicleModel model;

    @Column(nullable = false)
    private String color;

    public Vehicle() {
    }


    public long getId() {
        return this.id;
    }

    public VehicleModel getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vehicle)) return false;
        final Vehicle other = (Vehicle) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.id != other.id) return false;
        final Object this$model = this.model;
        final Object other$model = other.model;
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        final Object this$color = this.color;
        final Object other$color = other.color;
        if (this$color == null ? other$color != null : !this$color.equals(other$color)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.id;
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $model = this.model;
        result = result * PRIME + ($model == null ? 0 : $model.hashCode());
        final Object $color = this.color;
        result = result * PRIME + ($color == null ? 0 : $color.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Vehicle;
    }

    public String toString() {
        return "com.thinkful.spring.entity.Vehicle(id=" + this.id + ", model=" + this.model + ", color=" + this.color + ")";
    }
}
