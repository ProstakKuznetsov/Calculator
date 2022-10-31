class CalculatorException extends Throwable {
    String message;

    public CalculatorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
