package com.thinkful.contract.dto;

public class VehicleModelDto {
    private Integer id;
    private String name;

    public VehicleModelDto() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VehicleModelDto)) return false;
        final VehicleModelDto other = (VehicleModelDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.id;
        result = result * PRIME + ($id == null ? 0 : $id.hashCode());
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 0 : $name.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehicleModelDto;
    }

    public String toString() {
        return "com.thinkful.contract.dto.VehicleModelDto(id=" + this.id + ", name=" + this.name + ")";
    }
}
