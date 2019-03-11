package com.rohifa.robocleaner.services;

import com.rohifa.robocleaner.model.Area;
import com.rohifa.robocleaner.model.Position;
import org.springframework.stereotype.Service;

@Service
public class CleaningServiceImpl implements CleaningService {

    @Override
    public Position move(Position from, Character to, Area area) {

        Position next = computeNextPosition(from, to);
        boolean valid = validatePosition(next, area);

        if (valid) return next;
        else return from;

    }

    @Override
    public boolean clean(Position p, Area area) {
        if (area.getPatches().contains(p)) {
            area.getPatches().remove(p);
            return true;
        } else return false;
    }

    private boolean validatePosition(Position p, Area a) {
        return p.getX()>=0 && p.getX()< a.getWidth() && p.getY()>=0 && p.getY()<a.getHeight();

    }

    private Position computeNextPosition(Position from, Character to) {

        if (to == 'N') return new Position(from.getX(), from.getY()+1);
        else if (to=='S') return new Position(from.getX(), from.getY()-1);
        else if (to=='E') return new Position(from.getX()+1, from.getY());
        else return new Position(from.getX()-1, from.getY());

    }

}
