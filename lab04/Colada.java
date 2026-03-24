public class Colada {
    private Blender myBlender;
    private Vector myStuff;

    public Colada(){
        myBlender = new Blender();
        myStuff = new Vector();
    }

    private void doSomething(){
        myBlender.addIngredients(myStuff.elements());
    }
}
