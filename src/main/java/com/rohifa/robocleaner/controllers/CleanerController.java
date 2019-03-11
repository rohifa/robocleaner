package com.rohifa.robocleaner.controllers;

import com.rohifa.robocleaner.model.Area;
import com.rohifa.robocleaner.model.CleaningRequest;
import com.rohifa.robocleaner.model.Position;
import com.rohifa.robocleaner.services.CleaningService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CleanerController {

    private CleaningService cleaningService;

    public CleanerController(CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }

    @PostMapping(value = "/clean")
    public CleaningResponse clean(@Valid @RequestBody CleaningRequest cleaningRequest) {

        List<Position> oilPatches = cleaningRequest.getOilPatches().stream()
                                            .map(patch -> new Position(patch[0], patch[1]))
                                            .collect(Collectors.toList());

        Position initialPosition = new Position(cleaningRequest.getStartingPosition()[0], cleaningRequest.getStartingPosition()[1]);
        Area area = new Area(cleaningRequest.getAreaSize()[0], cleaningRequest.getAreaSize()[1], oilPatches);

        Position nextPosition = initialPosition;
        int cleaned = 0;
        for (Character c : cleaningRequest.getNavigationInstructions().toCharArray()) {
            nextPosition = cleaningService.move(nextPosition, c, area);
            if (cleaningService.clean(nextPosition, area)) cleaned++;
        }

        return new CleaningResponse(new Integer[]{nextPosition.getX(), nextPosition.getY()}, cleaned);

    }

}
