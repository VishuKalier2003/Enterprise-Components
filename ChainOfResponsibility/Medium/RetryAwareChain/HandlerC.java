public class HandlerC implements Handle {

    public Handle next;

    @Override
    public void setNext(Handle handle) {
        this.next = handle;
    }

    @Override
    public Handle getNext() {return next;}

    @Override public String handle(String input) {
        if(!Character.isUpperCase(input.charAt(0)))
            return input+" handler C failed !! \n";
        return input+" Handler C passed !! \n";
    }
}
