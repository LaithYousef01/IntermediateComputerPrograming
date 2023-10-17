package Email;


class MalformedEmailAddressException extends Exception {
    private static final long serialVersionUID = 1L;

	public MalformedEmailAddressException(String message) {
        super(message);
    }
}