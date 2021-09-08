package BLL.LoginBLL;

import DAL.LoginDAL.LoginDAL;
import DTO.NhanVien;

public class LoginBLL {
	LoginDAL loginDAL = new LoginDAL();
	public NhanVien login(String username, String password) {
		NhanVien nhanvienDTO = loginDAL.login(username, password); 
		return nhanvienDTO;
	}
}
