public class HandlerA implements Handle {

    public Handle next;

    @Override
    public void setNext(Handle handle) {
        this.next = handle;
    }

    @Override
    public Handle getNext() {return next;}

    @Override
    public String handle(String input) {
        if(!Character.isUpperCase(input.charAt(0)))
            return input+" handler A failed !! \n";
        return input+" Handler A passed !! \n";
    }
}
