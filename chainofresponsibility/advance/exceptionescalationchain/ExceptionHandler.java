package chainofresponsibility.advance.exceptionescalationchain;

public interface ExceptionHandler<T extends ExceptionError> {
    public void resolve(Data data, T exceptionError);
}
