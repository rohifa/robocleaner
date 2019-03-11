package com.rohifa.robocleaner.services;

import com.rohifa.robocleaner.model.Area;
import com.rohifa.robocleaner.model.Position;

public interface CleaningService {

    Position move(Position from, Character to, Area area);

    boolean clean(Position p, Area area);
}
