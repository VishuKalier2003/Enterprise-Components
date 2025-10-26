public class BHandlerB implements HandleX {

    public HandleX next;

    @Override
    public void setNext(HandleX handle) {
        this.next = handle;
    }

    @Override
    public HandleX getNext() {return next;}

    @Override
    public String handle(String input) {
        if(!Character.isUpperCase(input.charAt(0)))
            return input+" handler B failed !! ";
        return input+" Handler B passed !! ";
    }
}
