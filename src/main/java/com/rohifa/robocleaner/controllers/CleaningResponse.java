package com.rohifa.robocleaner.controllers;

import com.rohifa.robocleaner.model.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CleaningResponse {

    Integer[] finalPosition;
    Integer oilPatchesCleaned;
}
