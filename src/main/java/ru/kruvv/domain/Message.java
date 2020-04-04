/**
 * 
 */
package ru.kruvv.domain;

import lombok.Data;

/**
 * @author viktor
 * 
 * This simple objects message where:
 * fild form will contain the name of the recipient and 
 * fild message will contain some message.
 *
 */
@Data
public class Message {

	private String form;
	private String message;
}
