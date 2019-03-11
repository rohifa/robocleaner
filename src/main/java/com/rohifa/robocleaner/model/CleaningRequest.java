package com.rohifa.robocleaner.model;

import com.rohifa.robocleaner.validators.AreaSizeValidator;
import com.rohifa.robocleaner.validators.InitialPositionValidator;
import com.rohifa.robocleaner.validators.OilPatchesValidator;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@OilPatchesValidator
@InitialPositionValidator
public @Data class CleaningRequest {

    @NotNull
    @Size(min = 2, max = 2)
    @AreaSizeValidator
    private Integer[] areaSize;

    @NotNull
    @Size(min = 2, max = 2)
    private Integer[] startingPosition;

    @NotNull
    private List<Integer[]> oilPatches;

    @NotNull
    @Pattern(regexp = "[NSEW]+")
    private String navigationInstructions;



}
