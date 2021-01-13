class Actor{
    public void work(){
        System.out.println("Doing Acting");
    }
}
class Director {
    public void work(){
        System.out.println("Directing");
    }
}
public class Assignment14 {
    public static void main(String[]args){
        Actor act = new Actor();
        Director dir = new Director();
        act.work();
        dir.work();
    }
}
