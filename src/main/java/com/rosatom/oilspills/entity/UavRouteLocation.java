package com.rosatom.oilspills.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavRouteLocation extends AbstractEntity {

    @NotNull
    private UUID uavRouteId;

    @NotNull
    private UUID locationId;

    public UavRouteLocation(UUID locationId) {
        this.locationId=locationId;
    }
}
