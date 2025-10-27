package chainofresponsibility.advance.exceptionescalationchain;

public abstract class ExceptionError extends Throwable {
    private final String code, data;
    private final int errorCode;

    public ExceptionError(String code, String message, int eCode) {
        super(message);
        this.code = code;
        this.data = message;
        this.errorCode = eCode;
    }

    public String getCode() {return this.code;}
    public String getData() {return this.data;}
    public int getErrorCode() {return this.errorCode;}
}
