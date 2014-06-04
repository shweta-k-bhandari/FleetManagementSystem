package com.FMS.utils;

import com.FMS.constants.ErrorConstants;

public class FMSUtils {

	public static String validateString(String value) throws FmsException {
		if (value == null || value.isEmpty()) {
			throw new FmsException(ErrorConstants.INVALID_FIELD_VALUE
					.getErrorCode(), ErrorConstants.INVALID_FIELD_VALUE
					.getErrorMessage());
		}
		else 
			return value;
	}
	
	public static int validateInteger(String value) throws FmsException {
		if (value == null || value.isEmpty()) {
			throw new FmsException(ErrorConstants.INVALID_FIELD_VALUE
					.getErrorCode(), ErrorConstants.INVALID_FIELD_VALUE
					.getErrorMessage());
		} else {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) {
				throw new FmsException(ErrorConstants.INVALID_FIELD_VALUE
						.getErrorCode(), ErrorConstants.INVALID_FIELD_VALUE
						.getErrorMessage());
			}
		}
	}
}
