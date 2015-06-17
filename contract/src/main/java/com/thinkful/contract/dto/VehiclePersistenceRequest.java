package com.thinkful.contract.dto;

public class VehiclePersistenceRequest {
    private Long id;
    private Integer modelId;
    private String color;

    public VehiclePersistenceRequest() {
    }

    public Long getId() {
        return this.id;
    }

    public Integer getModelId() {
        return this.modelId;
    }

    public String getColor() {
        return this.color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VehiclePersistenceRequest)) return false;
        final VehiclePersistenceRequest other = (VehiclePersistenceRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$modelId = this.modelId;
        final Object other$modelId = other.modelId;
        if (this$modelId == null ? other$modelId != null : !this$modelId.equals(other$modelId)) return false;
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
        final Object $modelId = this.modelId;
        result = result * PRIME + ($modelId == null ? 0 : $modelId.hashCode());
        final Object $color = this.color;
        result = result * PRIME + ($color == null ? 0 : $color.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehiclePersistenceRequest;
    }

    public String toString() {
        return "com.thinkful.contract.dto.VehiclePersistenceRequest(id=" + this.id + ", modelId=" + this.modelId + ", color=" + this.color + ")";
    }
}
