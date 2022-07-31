package com.cgi.boat.interview;

/**
 *
 * @author ador
 */
public class FirstnameWithCount {

	public final String firstname;
	public final int count;

	public FirstnameWithCount(String firstname, int count) {
		this.firstname = firstname;
		this.count = count;
	}

	@Override
	public String toString() {
		return String.format("%s: %d", firstname, count);
	}

}
