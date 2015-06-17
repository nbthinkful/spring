package com.thinkful.contract.dto;

public class VehicleDto {
    private Long id;
    private VehicleModelDto model;
    private String color;

    public VehicleDto() {
    }

    public Long getId() {
        return this.id;
    }

    public VehicleModelDto getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(VehicleModelDto model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VehicleDto)) return false;
        final VehicleDto other = (VehicleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
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
        final Object $id = this.id;
        result = result * PRIME + ($id == null ? 0 : $id.hashCode());
        final Object $model = this.model;
        result = result * PRIME + ($model == null ? 0 : $model.hashCode());
        final Object $color = this.color;
        result = result * PRIME + ($color == null ? 0 : $color.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehicleDto;
    }

    public String toString() {
        return "com.thinkful.contract.dto.VehicleDto(id=" + this.id + ", model=" + this.model + ", color=" + this.color + ")";
    }
//    private DateTime date = DateTime.now();
}
