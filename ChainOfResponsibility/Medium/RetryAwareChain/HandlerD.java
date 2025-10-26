public class HandlerD implements Handle {

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
            return input+" handler D failed !! \n";
        return input+" Handler D passed !! \n";
    }
}
