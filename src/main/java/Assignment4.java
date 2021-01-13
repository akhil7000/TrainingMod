public class Assignment4 {
    public static void main(String[] args) {
        //Get the substring Corporation from name, //String name = "Indian Oil Corporation Ltd"
        String name = "Indian Oil Corporation Ltd";
        String sub = name.substring(name.indexOf('C'),name.lastIndexOf('n')+1);
        System.out.println(sub);
    }
}