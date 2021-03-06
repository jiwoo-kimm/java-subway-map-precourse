package subway.exception;

public class InvalidInputException extends RuntimeException {

    public enum ExceptionCode {
        INVALID_FUNCTION_INPUT
    }

    private final String HEADER = "\n[ERROR] ";

    private ExceptionCode exceptionCode;

    public InvalidInputException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getMessage() {
        if (exceptionCode.equals(ExceptionCode.INVALID_FUNCTION_INPUT))
            return HEADER + "선택할 수 없는 기능입니다.";
        return "";
    }
}
