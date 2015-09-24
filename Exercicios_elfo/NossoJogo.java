public class NossoJogo{
    public final static String NOME = "Bahhh of the rings";
    static public int contadorElfos = 0;

    public static void main(String[] args){
        if (args.length > 0){
            System.out.println("Olá " + args[0] + ", bem vindo ao " + NOME);
        }
    }
}