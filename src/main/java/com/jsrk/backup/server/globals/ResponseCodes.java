package com.jsrk.backup.server.globals;

/**
 * Response codes returned by the server.
 * <ul>
 * <li>{@link #INSERTED}</li>
 * <li>{@link #FORBIDDEN}</li>
 * <li>{@link #INTERNAL_SERVER_ERROR}</li>
 * </ul>
 */
public enum ResponseCodes {

	/**
	 * The insert request has succeeded.
	 * <ul>
	 * <li><code>code</code>: 201</li>
	 * <li><code>description</code>: Inserted</li>
	 * </ul>
	 */
	INSERTED(201, "Inserted"),

	/**
	 * The server understood the request, but is refusing to fulfill it due to
	 * unsatisfied conditions.
	 * <ul>
	 * <li><code>code</code>: 403</li>
	 * <li><code>description</code>: Forbidden</li>
	 * </ul>
	 */
	FORBIDDEN(403, "Forbidden"),

	/**
	 * The server encountered an unexpected condition which prevented it from
	 * fulfilling the request.
	 * <ul>
	 * <li><code>code</code>: 500</li>
	 * <li><code>description</code>: Internal Server Error</li>
	 * </ul>
	 */
	INTERNAL_SERVER_ERROR(500, "Internal Server Error");

	private final Integer code;

	private final String description;

	private ResponseCodes(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
