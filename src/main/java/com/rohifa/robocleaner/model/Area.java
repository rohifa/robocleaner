package com.rohifa.robocleaner.model;

import lombok.Getter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Area {

    private Set<Position> patches;
    private int width, height;

    public Area(int width, int height, List<Position> oilPatches) {
        this.width = width;
        this.height = height;
        patches = oilPatches.stream()
                .filter(position -> position.getX()<width && position.getY()<height)
                .collect(Collectors.toSet());

    }



}
