package subway.exception;

public class InvalidInputException extends RuntimeException {

    public enum ExceptionCode {
        INVALID_SERVICE_CODE,
        INVALID_FUNCTION_CODE,
        DUPLICATE_STATION,
        DUPLICATE_LINE,
        INVALID_NAME_LENGTH,
        NO_SUCH_STATION,
        NO_SUCH_LINE,
        NON_NUMBER_INPUT,
        OUT_OF_LINE_RANGE;
    }

    private final String HEADER = "\n[ERROR] ";

    private ExceptionCode exceptionCode;

    public InvalidInputException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getMessage() {
        if (exceptionCode.equals(ExceptionCode.INVALID_SERVICE_CODE) || exceptionCode.equals(ExceptionCode.INVALID_FUNCTION_CODE))
            return HEADER + "선택할 수 없는 기능입니다.";
        if (exceptionCode.equals(ExceptionCode.DUPLICATE_STATION))
            return HEADER + "이미 등록된 역 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.DUPLICATE_LINE))
            return HEADER + "이미 등록된 노선 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.INVALID_NAME_LENGTH))
            return HEADER + "이름은 두 글자 이상이어야 합니다.";
        if (exceptionCode.equals(ExceptionCode.NO_SUCH_STATION))
            return HEADER + "존재하지 않는 역 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.NO_SUCH_LINE))
            return HEADER + "존재하지 않는 노선 이름입니다.";
        if (exceptionCode.equals(ExceptionCode.NON_NUMBER_INPUT))
            return HEADER + "순서는 숫자로 입력해야 합니다.";
        if (exceptionCode.equals(ExceptionCode.OUT_OF_LINE_RANGE))
            return HEADER + "순서는 해당 노선의 범위 안에서 입력해야 합니다.";
        return "";
    }
}
