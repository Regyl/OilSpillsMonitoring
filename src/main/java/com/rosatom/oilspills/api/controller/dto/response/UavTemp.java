package com.rosatom.oilspills.api.controller.dto.response;

import com.rosatom.oilspills.entity.Location;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class UavTemp extends AbstractDtoResponse {
    private List<List<Long>> coordinates = new ArrayList<>(3);

    private String type = "LineString";

    public void addList(Location location) {
        this.coordinates.add(List.of(location.getLatitude(), location.getLongitude()));
    }

    public static UavTemp of(Location location1, Location location2, Location location3) {
        UavTemp uavTemp = new UavTemp();
        uavTemp.addList(location1);
        uavTemp.addList(location2);
        uavTemp.addList(location3);
        return uavTemp;
    }
}
