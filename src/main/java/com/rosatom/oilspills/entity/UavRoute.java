package com.rosatom.oilspills.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavRoute extends AbstractEntity {

    @NotNull
    private Long flightAltitude;

    @Transient
    private Set<UavRouteLocation> locations;

    public UavRoute addLocation(UavRouteLocation location) {
        if(this.locations == null) {
            this.locations = new HashSet<>();
        }
        this.locations.add(location);
        return this;
    }

    public UavRoute addAllLocation(Collection<UavRouteLocation> location) {
        if(this.locations == null) {
            this.locations = new HashSet<>();
        }
        this.locations.addAll(location);
        return this;
    }

}
