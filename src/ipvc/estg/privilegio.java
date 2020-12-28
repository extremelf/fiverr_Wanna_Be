package ipvc.estg;

public enum privilegio {


    ADMIN(1),
    UM(2),
    UTILIZADOR(3)
    ;

    private int i;



    privilegio(int i) {
        this.i=i;
    }

    public int getI(){
        return i;
    }
}
