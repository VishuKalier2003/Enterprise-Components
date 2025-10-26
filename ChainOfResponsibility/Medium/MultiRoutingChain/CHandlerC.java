public class CHandlerC implements HandleX {

    public HandleX next;

    @Override
    public void setNext(HandleX handle) {
        this.next = handle;
    }

    @Override
    public HandleX getNext() {return next;}

    @Override public String handle(String input) {
        if(!Character.isUpperCase(input.charAt(0)))
            return input+" handler C failed !! ";
        return input+" Handler C passed !! ";
    }
}
