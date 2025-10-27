package chainofresponsibility.advance.exceptionescalationchain;

public enum EnumOfException implements ExceptionHandler<ExceptionError> {

    NEGATIVE {
        @Override public void resolve(Data data, ExceptionError e) {
            System.out.println("======EXCEPTION FOUND======");
            System.out.println("| Exception code : "+e.getCode());
            System.out.println("| Error log      : "+e.getData());
            System.out.println("| Error code     : "+e.getErrorCode());
            System.out.println("===========================");
            data.setSum(Math.abs(data.getSum()));
            System.out.println("NEGATIVE exception resolved !!");
        }
    },
    PRIME {
        @Override public void resolve(Data data, ExceptionError e) {
            System.out.println("======EXCEPTION FOUND======");
            System.out.println("| Exception code : "+e.getCode());
            System.out.println("| Error log      : "+e.getData());
            System.out.println("| Error code     : "+e.getErrorCode());
            System.out.println("===========================");
            data.setSum(data.getSum()-2);
            System.out.println("PRIME exception resolved !!");
        }
    },
    ZERO {
        @Override public void resolve(Data data, ExceptionError e) {
            System.out.println("======EXCEPTION FOUND======");
            System.out.println("| Exception code : "+e.getCode());
            System.out.println("| Error log      : "+e.getData());
            System.out.println("| Error code     : "+e.getErrorCode());
            System.out.println("===========================");
            data.setSum(Math.abs(data.getSum()+1));
            System.out.println("ZERO exception resolved !!");
        }
    };

    public static void resolveError(Data data, ExceptionError e) {
        EnumOfException.valueOf(e.getCode()).resolve(data, e);
    }
}
