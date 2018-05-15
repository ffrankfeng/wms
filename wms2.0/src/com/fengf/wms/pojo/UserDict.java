package com.fengf.wms.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class UserDict implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 4375419708756403206L;
	
		private int user_aut;
		private String user_aut_dict;
		private List<User> user_aut_code;
		public UserDict() {
			super();
			// TODO 自动生成的构造函数存根
		}
		
		public UserDict(int user_aut, String user_aut_dict, List<User> user_aut_code) {
			super();
			this.user_aut = user_aut;
			this.user_aut_dict = user_aut_dict;
			this.user_aut_code = user_aut_code;
		}

		public UserDict(int user_aut, String user_aut_dict) {
			super();
			this.user_aut = user_aut;
			this.user_aut_dict = user_aut_dict;
		}
		public int getUser_aut() {
			return user_aut;
		}
		public void setUser_aut(int user_aut) {
			this.user_aut = user_aut;
		}
		public String getUser_aut_dict() {
			return user_aut_dict;
		}
		public void setUser_aut_dict(String user_aut_dict) {
			this.user_aut_dict = user_aut_dict;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public List<User> getUser_aut_code() {
			return user_aut_code;
		}

		public void setUser_aut_code(List<User> user_aut_code) {
			this.user_aut_code = user_aut_code;
		}

		@Override
		public String toString() {
			return "UserDict [user_aut=" + user_aut + ", user_aut_dict=" + user_aut_dict + ", user_aut_code="
					+ user_aut_code + "]\n";
		}


}
