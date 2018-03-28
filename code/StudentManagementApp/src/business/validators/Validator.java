package business.validators;

public interface Validator<T> {
	public boolean validate(T t1, String t2);
}
