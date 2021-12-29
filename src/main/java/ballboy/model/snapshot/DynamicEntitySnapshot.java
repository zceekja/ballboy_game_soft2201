package ballboy.model.snapshot;
import ballboy.model.entities.utilities.KinematicState;
import ballboy.model.entities.DynamicEntity;

public class DynamicEntitySnapshot implements SnapShot{


    private  KinematicState k;
    private DynamicEntity entity;
    public DynamicEntitySnapshot (DynamicEntity entity, KinematicState k){
        this.k = k;
        k.backup();
        this.entity = entity;
    }

    public void restore(){
        k.restore();
        entity.setKinematic(k);
    }
}
