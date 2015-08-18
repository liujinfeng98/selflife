package com.selflife.model;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class Command implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ec_command_id;
	private String ec_command_title;
	private String ec_command_shell;
	private int ec_cattag_code;		 
		 
		public int getEc_command_id() {
			return ec_command_id;
		}
		public void setEc_command_id(int ec_command_id) {
			this.ec_command_id = ec_command_id;
		}
		public String getEc_command_title() {
			return ec_command_title;
		}
		public void setEc_command_title(String ec_command_title) {
			this.ec_command_title = ec_command_title;
		}
		public String getEc_command_shell() {
			return ec_command_shell;
		}
		public void setEc_command_shell(String ec_command_shell) {
			this.ec_command_shell = ec_command_shell;
		}
		public int getEc_cattag_code() {
			return ec_cattag_code;
		}
		public void setEc_cattag_code(int ec_cattag_code) {
			this.ec_cattag_code = ec_cattag_code;
		}

	 
	 
}
