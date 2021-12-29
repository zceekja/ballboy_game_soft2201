To run program  
    'gradle run' will start the game.

Control
    Right Key : accelerate right
    Left Key : accelerate left
    Up Key : increase height
    S Key : Quick Save
    Q Key : Load Save


Feature implemented:
    1.Level transition
    2.Square Cat
    3.Score (Oberver design pattern)
    4.Save/Load (Memento Design pattern)

Design Pattern used in extension
    Extend Factory Pattern:
    1. add CatFactory class

    Extend Strategy Pattern:  
    1. add CatCollisionStrategy class
    2. add SquareCatBehaviourStrategy class

    Observer Design Pattern:
    1. add Observer interface 
    2. add TotalScoreDisplay class : 
    3. add CurrentScoreDisplay class : 
    4. add registerObserver , notifyObservers , getObservers method in Level and GameEngine
    5. GameEngineImpl is subject for TotalScoreDisplay.
    6. LevelImpl is subject for CurrentScoreDisplay.

    Momento Design Pattern:
    1. Add SnapShot inteface
    2. Add ControllableDynamicEntitySnapshot class
    3. Add CurrentScoreSnapShot class
    4. Add DynamicEntitySnapShot class
    5. Add GameEngineSnapShot class
    6. Add KinematicStateSnapShot class
    7. Add LevelSnapShot class
    8. Add TotalScoreSnapShot class
    9. Add Vector2DSnapShot class
    10. Add snapshot attribute, restore method, backup method to all class that need to store snapshot.
    
    