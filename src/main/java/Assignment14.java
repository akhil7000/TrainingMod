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
    new Actor().work();
    new Director().work();
}
}
