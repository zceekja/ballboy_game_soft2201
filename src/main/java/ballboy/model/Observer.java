package ballboy.model;

public interface Observer {
    public void update(Entity entity);
    public String print();
    public void backup();
    public void restore();
}
