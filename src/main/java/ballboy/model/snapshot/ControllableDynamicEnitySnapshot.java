package ballboy.model.snapshot;

import ballboy.model.entities.ControllableDynamicEntity;
import ballboy.model.entities.DynamicEntity;

public class ControllableDynamicEnitySnapshot <T extends DynamicEntity>  implements SnapShot {
    private  T entity;
    ControllableDynamicEntity con;

    public ControllableDynamicEnitySnapshot(ControllableDynamicEntity con,T entity){
        this.entity = entity;
        entity.backup();
        this.con = con;
    }
    public void restore(){
        entity.restore();
    }
}
