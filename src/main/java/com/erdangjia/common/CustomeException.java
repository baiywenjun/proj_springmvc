package com.erdangjia.common;

@SuppressWarnings("serial")
public class CustomeException extends RuntimeException{

		private String code;
		private String message;
		
		public CustomeException(String code, String message){
			this.code = code;
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
}
