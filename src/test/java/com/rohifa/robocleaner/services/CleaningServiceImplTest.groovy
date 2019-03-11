package com.rohifa.robocleaner.services

import com.rohifa.robocleaner.model.Area
import com.rohifa.robocleaner.model.Position
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CleaningServiceImplTest extends Specification {

    @Shared
    def cleaningService = new CleaningServiceImpl()

    @Shared
    Area area = new Area(5,5, [new Position(1,1)])

    @Unroll
    def moveRobot(){


        expect:
            destination == cleaningService.move(from, to, area)
        where:
            from                       |   to         | destination
            new Position(0,0)   |  'N' as char | new Position(0,1)
            new Position(4,0)   |  'N' as char | new Position(4,1)
            new Position(4,0)   |  'E' as char | new Position(4,0)
            new Position(1,0)   |  'W' as char | new Position(0,0)
            new Position(5,0)   |  'E' as char | new Position(5,0)
            new Position(0,-1)  | 'E' as char  | new Position(0,-1)
            new Position(0,4)   | 'E' as char  | new Position(1,4)
            new Position(0,4)   | 'N' as char  | new Position(0,4)
            new Position(0,4)   | 'S' as char  | new Position(0,3)
            new Position(0,0)   | 'S' as char  | new Position(0,0)


    }

    def "check cleaning"(){
        expect:
            cleaned == cleaningService.clean(position, area)
        where:
            position                    | cleaned
            new Position(1,1)    |   true
            new Position(0,1)    |   false
    }

}
